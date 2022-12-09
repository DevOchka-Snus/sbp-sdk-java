package raiffeisen.sbp.sdk.model.out;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import raiffeisen.sbp.sdk.util.DateUtil;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class Order {

    private static final DateTimeFormatter TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");

    @Setter(AccessLevel.NONE)
    private BigDecimal amount;
    private OrderQr qr;
    private OrderExtra extra;
    private String id;
    private String comment;
    private String createDate;
    private String expirationDate;

    public void verify() {
        createDate = DateUtil.checkDate(createDate);
        expirationDate = DateUtil.calculateExpirationDate(expirationDate, createDate, "Order.expirationDate");
    }

}
