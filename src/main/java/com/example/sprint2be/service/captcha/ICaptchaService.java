package com.example.sprint2be.service.captcha;

import com.example.sprint2be.model.captcha.ReCaptchaInvalidException;

public interface ICaptchaService {

        default void processResponse(final String response) throws ReCaptchaInvalidException {}

        default void processResponse(final String response, String action) throws ReCaptchaInvalidException {}

        String getReCaptchaSite();

        String getReCaptchaSecret();

}
