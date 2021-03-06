package com.flutterwave.raveandroid.card;


import com.flutterwave.raveandroid.Payload;
import com.flutterwave.raveandroid.data.SavedCard;
import com.flutterwave.raveandroid.responses.ChargeResponse;

import java.util.List;

/**
 * Created by hamzafetuga on 05/07/2017.
 */

public interface CardContract {

    interface View {
        void showProgressIndicator(boolean active);
        void onPaymentError(String message);

        void onPinAuthModelSuggested(Payload payload);

        void showToast(String message);

        void showOTPLayout(String flwRef);

        void onValidateSuccessful(String message, String responseAsString);

        void onValidateError(String message);

        void onVBVAuthModelUsed(String authUrlCrude, String flwRef);

        void onPaymentSuccessful(String status, String flwRef, String responseAsString);

        void onPaymentFailed(String status, String responseAsString);

        void showFullProgressIndicator(boolean active);

        void showSavedCards(List<SavedCard> cards);

        void onTokenRetrieved(String flwRef, String cardBIN, String token);

        void onTokenRetrievalError(String s);

        void displayFee(String charge_amount, Payload payload, int why);

        void showFetchFeeFailed(String s);

        void hideSavedCardsButton();

        void onChargeTokenComplete(ChargeResponse response);

        void onChargeCardSuccessful(ChargeResponse response);

        void onAVS_VBVSECURECODEModelSuggested(Payload payload);

        void onAVSVBVSecureCodeModelUsed(String authurl, String flwRef);
    }

    interface UserActionsListener {
        void chargeCard(Payload payload);

        void chargeCardWithSuggestedAuthModel(Payload payload, String pin, String authModel);

        void validateCardCharge(String flwRef, String otp, String PBFPubKey);

        void requeryTx(String flwRef, String SECKEY, boolean shouldISaveCard);

        void requeryTxForToken(String flwRef, String SECKEY);

        void savePotentialCardDets(String cardFirst6, String cardLast4);

        void onSavedCardsClicked(String email);

        void chargeToken(Payload payload);

        void saveThisCard(String email, String flwRef, String secretKey);

        void fetchFee(Payload payload, int reason);

        void checkForSavedCards(String email);
    }

}
