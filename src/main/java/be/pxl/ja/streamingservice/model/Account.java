package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();
    private PaymentInfo paymentInfo;

    public Account(String email, String password) {
        this.email = email;
        this.password = PasswordUtil.encodePassword(password);
        this.profiles.add(new Profile("profile1"));
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }
}
