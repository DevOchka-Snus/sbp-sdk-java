package raiffeisen.sbp.sdk.model.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentInfo {

    private String additionalInfo;
    private BigDecimal amount;
    private String code;
    private String createDate;
    private String currency;
    private long merchantId;
    private String order;
    private String paymentStatus;
    private String qrId;
    private String sbpMerchantId;
    private String transactionDate;
    private long transactionId;
}
