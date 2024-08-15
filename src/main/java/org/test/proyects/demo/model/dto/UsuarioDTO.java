package org.test.proyects.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO implements Serializable {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("password")
    private String password;

    @JsonProperty("alumno_id")
    private Long alumnoId;  // Asumiendo que alumno_id es del tipo Long en DTO
}
