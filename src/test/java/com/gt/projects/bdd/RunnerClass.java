package com.gt.projects.bdd;

import com.gt.projects.bdd.base.AbstractCucumberRunner;
import com.gt.projects.bdd.base.annotation.Tags;
import com.gt.projects.bdd.base.interceptor.ReportEventListener;
import com.gt.projects.bdd.hsbc_gbm.util.RegionUtil;
import com.gt.projects.bdd.hsbc_gbm.util.UserProfileUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.formatter.Formatter;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Data;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Test
@CucumberOptions(
        features = {
                /** Sprint 1 */
//                "src/test/resources/feature/Sprint1/S1_OverviewAssetClass.feature",
//                "src/test/resources/feature/Sprint1/S2_OverviewSubAssetClass.feature",
//                "src/test/resources/feature/Sprint1/S5_AccountAssetClass.feature",
//                "src/test/resources/feature/Sprint1/S6_AccountSubAssetClass.feature",
//                "src/test/resources/feature/Sprint1/S9_PortfolioAssetClass.feature",
//                "src/test/resources/feature/Sprint1/S10_PortfolioSubAssetClass.feature",
//
//                "src/test/resources/feature/Sprint1/S3_OverviewAssetRegion.feature",
//                "src/test/resources/feature/Sprint1/S4_OverviewAssetCurrency.feature",
//                "src/test/resources/feature/Sprint1/S7_AccountAssetRegion.feature",
//                "src/test/resources/feature/Sprint1/S8_AccountAssetCurrency.feature",
//                "src/test/resources/feature/Sprint1/S11_PortfolioAssetRegion.feature",
//                "src/test/resources/feature/Sprint1/S12_PortfolioAssetCurrency.feature",
//                "src/test/resources/feature/Sprint1/S13_OverviewAssetClassHoldings.feature",
//                "src/test/resources/feature/Sprint1/S14_AccountAssetClassHoldings.feature",
//                "src/test/resources/feature/Sprint1/S15_PortfolioAssetClassHoldings.feature",
//                "src/test/resources/feature/Sprint1/S16_PortfolioRegionHoldings.feature",
//                "src/test/resources/feature/Sprint1/S17_AccountRegionHoldings.feature",
//                "src/test/resources/feature/Sprint1/S18_OverviewRegionHoldings.feature",
//                "src/test/resources/feature/Sprint1/S19_OverviewCurrencyHoldings.feature",
//                "src/test/resources/feature/Sprint1/S20_AccountCurrencyHoldings.feature",
//                "src/test/resources/feature/Sprint1/S21_PortfolioCurrencyHoldings.feature",
//                "src/test/resources/feature/Sprint1/S22_PortfolioList.feature",
//
//                "src/test/resources/feature/Sprint1/S23_AccountTotalAsset.feature",
//                "src/test/resources/feature/Sprint1/S24_AccountTotalAssetOverlay.feature",
//                "src/test/resources/feature/Sprint1/S25_AccountLists.feature",
//                "src/test/resources/feature/Sprint1/S26_OverviewTotalAsset.feature",
//                "src/test/resources/feature/Sprint1/S27_OverviewTotalAssetOverlay.feature",
//                "src/test/resources/feature/Sprint1/S28_PortfolioTotalAsset.feature",
//                "src/test/resources/feature/Sprint1/S29_PortfolioTotalAssetsOverlay.feature",
//
                 /** Sprint 2 */
//                "src/test/resources/feature/Sprint2/S2_Sub-assetClassBreakdownOverviewLevel.feature",
//                "src/test/resources/feature/Sprint2/S6_Sub-assetClassBreakdownAccountLevel.feature",
//                "src/test/resources/feature/Sprint2/S10_Sub-assetClassBreakdownPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint2/S30_AssetAllocationUnavailable.feature",
//                "src/test/resources/feature/Sprint2/S38_MoreMenu.feature",
//                "src/test/resources/feature/Sprint2/S39_GlossaryOfTerms.feature",
//                "src/test/resources/feature/Sprint2/S40_DisplayUsername.feature",
//                "src/test/resources/feature/Sprint2/S41_DisplayLastLogin.feature",
//                "src/test/resources/feature/Sprint2/S42_LogOut.feature",

//                //hide in sprint5（sprint 2）
////                "src/test/resources/feature/Sprint2/S31_ContingentLiabilities.feature",
////                "src/test/resources/feature/Sprint2/S32_Contingent_Liabilities.feature",
////                "src/test/resources/feature/Sprint2/S33_ContingentLiabilitiesLists.feature",
////                "src/test/resources/feature/Sprint2/S34_ExitingContingentLiabilityDetail.feature",
////                "src/test/resources/feature/Sprint2/S35_ContingentLiabilityDetailed.feature",
////                "src/test/resources/feature/Sprint2/S36_ExitContingentLiabilities.feature",
////                "src/test/resources/feature/Sprint2/S37_ContingentLiabilitiesOverlay.feature",
//
                 /** Sprint 3 */
//                "src/test/resources/feature/Sprint3/S74_TransactionsListView.feature",
//                "src/test/resources/feature/Sprint3/S76_NoTransactions.feature",
//                "src/test/resources/feature/Sprint3/S77_ApplyTransactionsFilter.feature",
//                "src/test/resources/feature/Sprint3/S80_NoHoldings.feature",

                 /** Sprint 4 */
//                "src/test/resources/feature/Sprint4/S114_TransactionOrder.feature",
//                "src/test/resources/feature/Sprint4/S115_AccessTransactionFilter.feature",
//                "src/test/resources/feature/Sprint4/S120_LinkToKRC.feature",
//                "src/test/resources/feature/Sprint4/S129_PipAnimation.feature",
//                "src/test/resources/feature/Sprint4/S130_PipAnimationLogic.feature",
//
                /** Sprint 5 */
//                "src/test/resources/feature/Sprint5/S181_HoldingListView.feature",
//                "src/test/resources/feature/Sprint5/S186_TransactionsDetailedViewAccess.feature",
//                "src/test/resources/feature/Sprint5/S187_TransactionsDetailsView.feature",
//                "src/test/resources/feature/Sprint5/S208_HoldingsDetails_Equities.feature",
//                "src/test/resources/feature/Sprint5/S209_HoldingsDetails_PreciousMetals.feature",
//                "src/test/resources/feature/Sprint5/S210_HoldingsDetails_Funds.feature",
//                "src/test/resources/feature/Sprint5/S211_HoldingsDetails_CurrentAccounts.feature",
//                "src/test/resources/feature/Sprint5/S212_HoldingsDetails_MetalOunces.feature",
//                "src/test/resources/feature/Sprint5/S214_HoldingsDetails_DirectInvestments.feature",
//                "src/test/resources/feature/Sprint5/S213_HoldingsDetails_Derivatives.feature",
//                "src/test/resources/feature/Sprint5/S215_HoldingsDetails_InterestRateSwaps.feature",
//                "src/test/resources/feature/Sprint5/S216_HoldingDetailFutures.feature",
//                "src/test/resources/feature/Sprint5/S217_HoldingsDetails_ForeignExchange(FX).feature",
//                "src/test/resources/feature/Sprint5/S218_HoldingsDetails_PrivateEquity&RealEstateFunds.feature",
//                "src/test/resources/feature/Sprint5/S219_HoldingsDetails_Deposits.feature",
//                "src/test/resources/feature/Sprint5/S220_HoldingsDetails_Bonds.feature",
//                "src/test/resources/feature/Sprint5/S221_HoldingsDetails_StructuredProducts.feature",
//                "src/test/resources/feature/Sprint5/S232_Currency.feature",
//                "src/test/resources/feature/Sprint5/S234_MoreMenuChangeUI.feature",
//
                /** Sprint 6 */
//                "src/test/resources/feature/Sprint6/S240_OverviewPerformance.feature",
//                "src/test/resources/feature/Sprint6/S241_AccountListPerformance.feature",
//                "src/test/resources/feature/Sprint6/S242_AccountPerformance.feature",
//                "src/test/resources/feature/Sprint6/S243_PortfolioListPerformance.feature",
//                "src/test/resources/feature/Sprint6/S244_PortfolioPerformance.feature",
//                "src/test/resources/feature/Sprint6/S245_HoldingsPerformancePortfolioList.feature",
//                "src/test/resources/feature/Sprint6/S246_HoldingsPerformanceAssetAllocation.feature",
//                "src/test/resources/feature/Sprint6/S247_OverlaysPerformance.feature",
//                "src/test/resources/feature/Sprint6/S248_CloseOverlayPerformance.feature",
//                "src/test/resources/feature/Sprint6/S262_LegalSectionOverview.feature",
//                "src/test/resources/feature/Sprint6/S263_T&CSectionOfLegal.feature",
//                "src/test/resources/feature/Sprint6/S265_PrivacyPolicySectionOfLegal.feature",
//                "src/test/resources/feature/Sprint6/S267_AccessibilityStatement.feature",
//                "src/test/resources/feature/Sprint6/S269_DisplayLastLoginAmendment.feature",
//                "src/test/resources/feature/Sprint6/S275_GlobalLegalDisclaimer.feature",
//                "src/test/resources/feature/Sprint6/S293_HoldingsListView.feature",
//                "src/test/resources/feature/Sprint6/S294_HoldingsListViewInAssetAllocationModeAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint6/S296_HoldingsListViewInAssetAllocationModeAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint6/S348_HideContingentLiabilitiesInPortfolio.feature",
//                "src/test/resources/feature/Sprint6/S351_UpdateCurrencyConversionDisclaimer.feature",
//                "src/test/resources/feature/Sprint6/S354_WrapperHoldingListAssetAllocation.feature",
//                "src/test/resources/feature/Sprint6/S358_HoldingsByAssetClassAndSub-AssetClassAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint6/S360_HoldingsByAssetClassAndSub-AssetClassAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint6/S362_HoldingsByAssetClassAndSub-AssetClassAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint6/S364_HoldingsPerRegionAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint6/S366_HoldingsPerRegionAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint6/S368_HoldingsPerRegionAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint6/S370_HoldingsPerCurrencyAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint6/S373_HoldingsPerCurrencyAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint6/S375_HoldingsPerCurrencyAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint6/S376_UpdateAccountTotalAssetsHeaderOverlay.feature",
//                "src/test/resources/feature/Sprint6/S377_UpdatePortfolioTotalAssetsHeaderOverlay.feature",
//                "src/test/resources/feature/Sprint6/S378_TotalAssetAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint6/S379_TotalAssetAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint6/S386_UpdateBookingCentreNameOnOverview.feature",
//                "src/test/resources/feature/Sprint6/S299_HoldingsDetailsEquitiesAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S300_HoldingsDetailsPreciousMetalsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S302_HoldingsDetailsFundsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S304_HoldingsDetailsStructuredProductsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S307_HoldingsDetailsCurrentAccountsBlockedCurrentAccountsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S309_HoldingsDetailsMetalOuncesAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S311_HoldingsDetailsDerivativesAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S313_HoldingsDetailsDirectInvestmentsPrivateEquityPromemoriaAndOtherAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S315_HoldingsDetailsInterestRateSwapsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S317_HoldingsDetailsPrivateEquity&RealEstateFundsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S319_HoldingsDetailsDepositsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S321_HoldingsDetailsBondsAccountLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S387_HoldingsDetailsEquitiesPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S388_HoldingsDetailsPreciousMetalsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S389_HoldingsDetailsFundsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S390_HoldingsDetailsStructuredProductsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S391_HoldingsDetailsCurrentAccountsBlockedCurrentAccountsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S392_HoldingsDetailsMetalOuncesPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S393_HoldingsDetailsDerivativesPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S394_HoldingsDetailsDirectInvestmentsPrivateEquityPromemoriaAndOtherPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S395_HoldingsDetailsInterestRateSwapsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S396_HoldingsDetailsPrivateEquity&RealEstateFundsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S397_HoldingsDetailsDepositsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S398_HoldingsDetailsBondsPortfolioLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S322_HoldingsDetailsEquitiesOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S324_HoldingsDetailsPreciousMetalsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S326_HoldingsDetailsFundsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S328_HoldingsDetailsCurrentAccountsBlockedCurrentAccountsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S330_HoldingsDetailsStructuredProductsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S332_HoldingsDetailsMetalOuncesOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S334_HoldingsDetailsDerivativesOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S336_HoldingsDetailsDirectInvestmentsPrivateEquityPromemoriaAndOtherOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S338_HoldingsDetailsPrivateEquity&RealEstateFundsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S339_HoldingsDetailsInterestRateSwapsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S342_HoldingsDetailsDepositsOverviewLevelAssetAllocationView.feature",
//                "src/test/resources/feature/Sprint6/S344_HoldingsDetailsBondsOverviewLevelAssetAllocationView.feature",

                 /** Sprint 7 */
//                "src/test/resources/feature/Sprint7/S416_TotalAssetsAtOverviewLevelDesignUpdate.feature",
//                "src/test/resources/feature/Sprint7/S417_TotalAssetsAtAccountLevelDesignUpdate.feature",
//                "src/test/resources/feature/Sprint7/S418_TotalAssetsAtPortfolioLevelDesignUpdate.feature",
//                "src/test/resources/feature/Sprint7/S421_ExchangeRatesHeaderUpdate.feature",
//                "src/test/resources/feature/Sprint7/S425_AppSystemHandingErrors.feature",
//                "src/test/resources/feature/Sprint7/S427_HideHoldingValueInBaseCurrency.feature",

                 /** Sprint 8 */
//                "src/test/resources/feature/Sprint8/S428_TotalLiabilitiesAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint8/S430_OverviewTotalLiabilitiesOverlaySingapore.feature",
//                "src/test/resources/feature/Sprint8/S431_OverviewTotalLiabilitiesOverlayHongKong.feature",
//                "src/test/resources/feature/Sprint8/S432_NetAssetsAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint8/S435_TotalLiabilitiesAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint8/S436_AccountTotalLiabilitiesOverlaySingapore.feature",
//                "src/test/resources/feature/Sprint8/S437_AccountTotalLiabilitiesOverlayHongKong.feature",
//                "src/test/resources/feature/Sprint8/S438_NetAssetsAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint8/S441_PortfolioTotalLiabilitiesOverlaySingapore.feature",
//                "src/test/resources/feature/Sprint8/S442_TotalLiabilitiesAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint8/S443_PortfolioTotalLiabilitiesOverlayHongKong.feature",
//                "src/test/resources/feature/Sprint8/S444_NetAssetsAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint8/S446_TotalLiabilitiesByTypeAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint8/S447_LiabilitiesListInPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint8/S448_LiabilitiesDetailedView.feature",
//                "src/test/resources/feature/Sprint8/S452_AccessibilityStatement.Feature",
//                "src/test/resources/feature/Sprint8/S460_AssetExposureAsiaNoRegionView.feature",
//                "src/test/resources/feature/Sprint8/S463_TransactionsAsia.feature",
//                "src/test/resources/feature/Sprint8/S485_OverviewTotalAssetsOverlayCopyUpdate.feature",
//                "src/test/resources/feature/Sprint8/S487_AccountTotalAssetsOverlayCopyUpdate.feature",
//                "src/test/resources/feature/Sprint8/S490_PortfolioTotalAssetsOverlayCopyUpdate.feature",

                /** Sprint 9 */
//                "src/test/resources/feature/Sprint9/S500_HideLinkToKrcInMoreMenuForUK.feature",
////                //"src/test/resources/feature/Sprint9/S501_PortfolioNameAsia.feature",
//                "src/test/resources/feature/Sprint9/S504_PerformanceAsiaDoNotShowPortfolioPerformance.feature",
//                "src/test/resources/feature/Sprint9/S507_PerformanceAsiaMobWrappers.feature",
//                "src/test/resources/feature/Sprint9/S509_PerformanceAsiaMobAccount&PortfolioLists.feature",
//                "src/test/resources/feature/Sprint9/S511_HoldingsAsiaPerformance.feature",
//                "src/test/resources/feature/Sprint9/S512_ReturnToMoreMenuFromDocumentsScreen.feature",
//                "src/test/resources/feature/Sprint9/S513_All_Unread_DocumentFilter.feature",
//                "src/test/resources/feature/Sprint9/S514_DocumentListItem_UK.feature",
//                "src/test/resources/feature/Sprint9/S515_All_Unread_Flagged_IndependentStates.feature",

                /** Sprint 10 */
//                "src/test/resources/feature/Sprint10/S530_EmptyStateAccountList.feature",
//                "src/test/resources/feature/Sprint10/S531_EmptyStatePortfolioList.feature",
                "src/test/resources/feature/Sprint10/S532_FilterByAccount_UK.feature",
//                "src/test/resources/feature/Sprint10/S533_PrivacyPolicySectionOfLegalAsia.feature",
//                "src/test/resources/feature/Sprint10/S534_RemoveClientUsername.feature",
//                "src/test/resources/feature/Sprint10/S535_SecutityTipsSectionOfLegal.feature",
//                "src/test/resources/feature/Sprint10/S536_TermsOfConditionsSectionOfLegal_Asia.feature",

                /** Sprint 11 */
//                "src/test/resources/feature/Sprint11/S560_ExchangeRateErrorDesignUpdates.feature",
//                "src/test/resources/feature/Sprint11/S561_RemovePerformanceAtOverview_UK.feature",
//                "src/test/resources/feature/Sprint11/S562_RemovePerformanceAtAccount_UK.feature",

                /** Sprint 14 */
//                "src/test/resources/feature/Sprint14/S590_AssetClassGraphicalViewAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint14/S3592_HoldingsByAssetClassAndSub-AssetClassAtOverviewLevel.feature",

                /** Sprint 15 */
//                "src/test/resources/feature/Sprint15/S3549_HoldingsByCurrencyAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint15/S3552_HoldingsByRegionAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint15/S3568_AssetClassGraphicalViewAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint15/S3569_AssetClassGraphicalViewAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint15/S3570_CurrencyGraphicalViewAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint15/S3571_CurrencyGraphicalViewAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint15/S3573_CurrencyGraphicalViewAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint15/S3574_RegionGraphicalViewAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint15/S3575_RegionGraphicalViewAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint15/S3576_RegionGraphicalViewAtPortfolioLevel.feature",

                /** Sprint 16 */
//                "src/test/resources/feature/Sprint16/S3475_AssetClassListAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint16/S3547_HoldingsByAssetClassAndSubAssetClassAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint16/S3548_HoldingsByAssetClassAndSubAssetClassAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint16/S3550_HoldingsByCurrencyAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint16/S3551_HoldingsByCurrencyAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint16/S3553_HoldingsByRegionAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint16/S3554_HoldingsByRegionAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint16/S3557_AssetClassListAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint16/S3562_CurrencyListAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint16/S3563_CurrencyListAtAccountLevel.feature",
//                "src/test/resources/feature/Sprint16/S3565_RegionListAtOverviewLevel.feature",
//                "src/test/resources/feature/Sprint16/S3566_RegionListAtAccountLevel.feature",

                /** Sprint 17 */
//                "src/test/resources/feature/Sprint17/S3558_TransactionDetailDisclaimerUpdate_Asia.feature",
//                "src/test/resources/feature/Sprint17/S3560_AssetClassListAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint17/S3561_ShowDisclaimerAtTheBottomOfTheGlossaryOfTerms-Asia.feature",
//                "src/test/resources/feature/Sprint17/S3564_CurrencyListAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint17/S3567_RegionListAtPortfolioLevel.feature",
//                "src/test/resources/feature/Sprint17/S3650_TreatmentWhenPositiveAndNegativeHoldingsSumTo0.feature",
//                "src/test/resources/feature/Sprint17/S3677_GraphicalViewCorrectionToNegativeNetAssetsScenario.feature",
//                "src/test/resources/feature/Sprint17/S3706_HoldingNameFullDisplay_Global.feature",

        },
//        format = {"pretty"},
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"com.gt.projects.bdd.hsbc_gbm.step"}
        ,tags = {"not @NotInMock"}
)
@Data
// This "Tags" annotation always will add the "appRegion" configured in POM.xml
//@Tags({"@S3560-AC8-AT5"})
public class RunnerClass extends AbstractCucumberRunner {

}