package pojo;

import java.util.List;

public class Courses {

    private List<WebAutomation> webAutomation;
    private List<Api> api;
    private List<Mobile> mobile;

    // Getters and Setters for WebAutomation
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    // Getters and Setters for API
    public List<Api> getApi() {
        return api;
    }

    public void setApi(List<Api> api) {
        this.api = api;
    }

    // Getters and Setters for Mobile
    public List<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }
}
