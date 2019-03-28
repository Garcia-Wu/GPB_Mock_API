package com.gt.projects.bdd.base;

import com.gt.projects.bdd.RunnerClass;
import com.gt.projects.bdd.base.annotation.Tags;
import com.gt.projects.bdd.base.interceptor.ReportEventListener;
import com.gt.projects.bdd.base.interceptor.ScenarioInterceptor;
import com.gt.projects.bdd.base.utils.GherkinUtils;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import cucumber.api.formatter.Formatter;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class AbstractCucumberRunner extends AbstractTestNGCucumberTests{

    /*===================== Runner =====================*/
    private static ThreadLocal<AbstractCucumberRunner> currentRunner = new ThreadLocal<AbstractCucumberRunner>();

    private String appiumPath;

    private String appRegion;

    private String automationServer;

    private String instrumentation;

    private String deviceName;

    private String platform;

    private String platformVersion;

    private String appPath;

    private String baseUrl;

    private String udid;

    private String temporaryFolder;

    private String pin;

    private String reportFolder;

    private String wdaLocalPort;

    private String xcodeOrgId;

    private String xcodeSigningId;

    private String newCommandTimeout;


    private String reportName;

    private Formatter cucumberReport;

    private ExecuteWatchdog videoRecorder;

    @Parameters({"automationServer", "platform", "instrumentation", "platformVersion", "deviceName", "appPath", "baseUrl", "udid", "temporaryFolder", "pin", "wdaLocalPort", "xcodeOrgId", "xcodeSigningId", "newCommandTimeout","appiumPath","appRegion","excelName"})
    @BeforeTest
    public void setRunner(

            String automationServer,
            String platform,
            @Optional String instrumentation,
            @Optional String platformVersion,
            @Optional String deviceName,
            @Optional String appPath,
            @Optional String baseUrl,
            @Optional String udid,
            @Optional String temporaryFolder,
            @Optional String pin,
            @Optional String wdaLocalPort,
            @Optional String xcodeOrgId,
            @Optional String xcodeSigningId,
            @Optional String newCommandTimeout,
            @Optional String appiumPath,
            @Optional String appRegion,
            @Optional String excelName
    ) {

        setAutomationServer(automationServer);
        setPlatform(platform);

        // For Mobile App
        setInstrumentation(instrumentation);
        setPlatformVersion(platformVersion);
        setDeviceName(deviceName);
        setAppPath(appPath);
        setUdid(udid);
        setTemporaryFolder(temporaryFolder);
        setPin(pin);
        setWdaLocalPort(wdaLocalPort);
        setXcodeOrgId(xcodeOrgId);
        setXcodeSigningId(xcodeSigningId);
        setNewCommandTimeout(newCommandTimeout);
        setAppiumPath(appiumPath);
        setAppRegion(appRegion);
        // For Web
        setBaseUrl(baseUrl);

        if(excelName != null){
            UserProfileUtil.excelName = excelName;
        }

//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(4723);
//        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
//        service.start();

        if(StringUtils.isNotBlank(appiumPath)){
            java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
            try {
                runtime.exec("node " + appiumPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UserProfileUtil.readExcel();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread currentThread = Thread.currentThread();
        currentThread.setName(currentThread.getName() + "-" + getPlatform() + "-" + getPlatformVersion() + "-" + getDeviceName());

        // For Reporting
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        reportName = platform + "_" + platformVersion + "_" + sdf.format(new Date());
    }

    @BeforeMethod(firstTimeOnly = true)
    public void initJsonPlugin() throws IOException, ReflectiveOperationException {


        try {
            reportFolder = "target/cucumber_json/" + reportName + "/";

            File rootDir = new File(reportFolder);
            if (!rootDir.exists()) {
                Files.createDirectories(Paths.get(reportFolder));
            }

            File jsonFile = new File(reportFolder, reportName + ".json");
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }

            File embeddingDir = new File(rootDir.getAbsolutePath(), "embeddings");
            if (!embeddingDir.exists()) {
                Files.createDirectories(Paths.get(embeddingDir.getAbsolutePath()));
            }

            cucumberReport = new ReportEventListener();
            addPlugin(cucumberReport);

//            Constructor constructor = Class.forName("cucumber.runtime.formatter.JSONFormatter").getConstructor(Appendable.class);
//            constructor.setAccessible(true);
//            cucumberReport = (Formatter)constructor.newInstance(new FileWriter(jsonFile));
//            addPlugin(cucumberReport);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @BeforeTest
    public void setCurrentRunner(){
        currentRunner.set(this);
    }
    
    public static AbstractCucumberRunner getCurrentRunner(){
        return currentRunner.get();
    }
    
    public static Runtime getCurrentRuntime(){
        try {
            AbstractCucumberRunner testRunner = RunnerClass.getCurrentRunner();
            TestNGCucumberRunner testNGCucumberRunner = (TestNGCucumberRunner) FieldUtils.getField(AbstractTestNGCucumberTests.class, "testNGCucumberRunner", true).get(testRunner);
            return (Runtime) FieldUtils.getField(TestNGCucumberRunner.class, "runtime", true).get(testNGCucumberRunner);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    /*===================== Scenario =====================*/
    @Getter
    private List<PickleEventWrapper> scenarioList;
    
    @DataProvider
    @Override
    public Object[][] scenarios() {
        System.out.println("appRegion:"+appRegion);
        
        Object[][] scenariosParameters = super.scenarios();
        List<Object[]> resultList = new ArrayList<Object[]>();
        scenarioList = new ArrayList<>();       // Register all test cases
        
        // Tags Filter
        Tags tags = AnnotationUtils.findAnnotation(this.getClass(), Tags.class);
        List<String> tagList = tags == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(tags.value()));
        // add region config
        if(StringUtils.isNotBlank(appRegion)){
            tagList.add("@"+appRegion);
        }

        int number = 0;
        for(Object[] parameters : scenariosParameters){
            if(parameters[0] != null){
    
                PickleEventWrapper wrapper = (PickleEventWrapper)parameters[0];
                List<String> wrapperTag = GherkinUtils.getTagList(wrapper.getPickleEvent().pickle.getTags());

//                if(!wrapperTag.contains("@NotAutomatable")){
//                    for(String tag : wrapperTag){
//                        if(tag.contains("-AT")){
//                            number++;
//                        }
//                    }
//                }


                if(wrapperTag.contains("@NotAutomatable")){
                } else if(tagList.isEmpty()){
                    resultList.add(parameters);
                    scenarioList.add(wrapper);
                } else {
                    for(String tag : wrapperTag){
                        if(tagList.contains(tag)){
                            resultList.add(parameters);
                            scenarioList.add(wrapper);
                            break;
                        }
                    }
                }
                
            }
        }
        System.out.println("Total AT number: --->>>"+number);
        
        return resultList.toArray(new Object[resultList.size()][]);
    }
    
    
    /*===================== Plugin =====================*/
        
    @Getter
    private ScenarioInterceptor scenarioInterceptor;
    
    protected void addPlugin(Formatter plugin){
        try {
            TestNGCucumberRunner runner = (TestNGCucumberRunner) FieldUtils.readField(this, "testNGCucumberRunner", true);
            RuntimeOptions runtimeOptions = (RuntimeOptions) FieldUtils.readField(runner, "runtimeOptions", true);
            
            runtimeOptions.addPlugin(plugin);
        } catch(ReflectiveOperationException ex){
            ex.printStackTrace();
        }
    }
    
    @BeforeMethod(firstTimeOnly = true)
    public void addPlugin() throws Exception{
        scenarioInterceptor = new ScenarioInterceptor();
        addPlugin(scenarioInterceptor);
    }
    
    
    /*===================== Bug fix =====================*/
    @AfterTest
    public void tearDown() throws Exception{
        tearDownClass();        // Trigger TestRunFinish event
    }

}
