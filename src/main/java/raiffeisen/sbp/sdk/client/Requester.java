package raiffeisen.sbp.sdk.client;

import raiffeisen.sbp.sdk.exception.SbpException;
import raiffeisen.sbp.sdk.model.Response;
import raiffeisen.sbp.sdk.web.WebClient;

import java.util.HashMap;
import java.util.Map;

public class Requester {

    protected WebClient webClient;

    public Requester(WebClient client) {
        webClient = client;
    }

    public void setWebClient(WebClient client) {
        webClient = client;
    }

    public WebClient getWebClient() {
        return webClient;
    }

    protected Map<String, String> prepareHeaders(String secretKey) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("charset", "UTF-8");
        if(secretKey != null) {
            headers.put("Authorization", "Bearer " + secretKey);
        }
        return headers;
    }

    protected Response responseOrThrow(Response response) throws SbpException {
        if(response.getBody() == null || response.getBody().length() == 0 || response.getBody().charAt(0) != '{') {
            SbpException e = new SbpException();
            e.setCode("HttpCode = " + response.getCode());
            e.setMessage("Ответ сервера: " + response.getBody());
            throw e;
        }
        return response;
    }
}
