package com.novacasa.Nova_Casa.model.service;

import com.novacasa.Nova_Casa.dto.AuthDTO;
import com.novacasa.Nova_Casa.form.AuthForm;

public interface AuthService {
	
    AuthDTO authenticate(AuthForm form);
}
