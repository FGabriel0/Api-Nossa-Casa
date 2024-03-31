package com.novacasa.Nova_Casa.model.serviceimpl;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novacasa.Nova_Casa.controller.dto.AuthDTO;
import com.novacasa.Nova_Casa.controller.form.AuthForm;
import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.AdminRepository;
import com.novacasa.Nova_Casa.model.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

	private String secretKey = "4f7337f863a794b8ed6bb8e4a0318ce6e2bdf1fa4f7337f863a794b8ed6bb8e4a0318ce6e2bdf1fa4f7337f863a794b8ed6bb8e4a0318ce6e2bdf1fa";
	private long jwtExpiration = 604800000;
	private long refreshExpiration = 86400000;
	
	private final AdminRepository repository;
	
	public AuthDTO authenticate(AuthForm form) {
		
		Optional<Usuario> adminOptional = repository.findByEmail(form.getEmail());
        if (adminOptional.isPresent()) {
            Usuario usuario = adminOptional.get();
            
            // Construir tokens JWT
            String accessToken = buildToken(new HashMap<>(), usuario.getEmail(), jwtExpiration);
            String refreshToken = buildToken(new HashMap<>(), usuario.getEmail(), jwtExpiration);

            // Construir DTO de autenticação
            AuthDTO dto = new AuthDTO();
            dto.setAccessToken(accessToken);
            dto.setRefreshToken(refreshToken);
            dto.setNome(usuario.getNome()); // Definir o nome do admin
            dto.setEmail(usuario.getEmail());
            dto.setPerfis(new ArrayList<>());
            dto.getPerfis().add("ADMINISTRADOR");
            dto.setExpiresIn("14400000"); // Tempo de expiração do token em milissegundos

            return dto;
        } else {
            throw new RegraNegocioException("Email não cadastrado");
        }
    }

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private String buildToken(Map<String, Object> extraClaims,  String userName, long expiration) {
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
	}
	

	
	
}
