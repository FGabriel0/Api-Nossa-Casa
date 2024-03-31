package com.novacasa.Nova_Casa.model.service;

import com.novacasa.Nova_Casa.controller.dto.AuthDTO;
import com.novacasa.Nova_Casa.controller.form.AuthForm;

public interface AuthService {
	
    AuthDTO authenticate(AuthForm form);
}
