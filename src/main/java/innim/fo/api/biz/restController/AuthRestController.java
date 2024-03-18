package innim.fo.api.biz.restController;

import innim.fo.api.biz.domain.service.JwtService;
import innim.fo.api.biz.dto.auth.AuthDtoRequest;
import innim.fo.api.sys.common.ApiClientResponse;
import innim.fo.api.sys.common.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final JwtService jwtService;

    @Operation(summary = "사용자 생성 [대내계]", description = "새로운 사용자를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "사용자 생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @Parameters({
            @Parameter(name = "userId", description = "수정할 사용자 ID"),
            @Parameter(name = "user", description = "수정할 사용자 정보")
    })
    @PostMapping("/createToken")
    public ResponseEntity<ApiClientResponse<?>> authenticate(@RequestBody AuthDtoRequest authRequest) {
        String token = jwtService.authenticateUser(authRequest.getUsername(), authRequest.getPassword());

        if (token != null) {
            return ResponseEntity.ok(
                    ApiClientResponse.builder()
                            .statusCode(SuccessCode.OK.getCode())
                            .message(SuccessCode.OK.getMessage())
                            .data(token).build());
        }

        return ResponseEntity.ok(
                ApiClientResponse.builder()
                        .statusCode(SuccessCode.UNAUTHORIZED.getCode())
                        .message(SuccessCode.UNAUTHORIZED.getMessage())
                        .data(null).build());
    }

    @Operation(summary = "사용자 조회 [대외계]", description = "특정 사용자의 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 정보 조회 성공",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    @GetMapping("/refreshToken")
    public ResponseEntity<ApiClientResponse<?>> refreshToken(String token) {
        String refreshToken = jwtService.generateRefreshToken(token);

        if (refreshToken != null) {
            return ResponseEntity.ok(
                    ApiClientResponse.builder()
                            .statusCode(SuccessCode.OK.getCode())
                            .message(SuccessCode.OK.getMessage())
                            .data(refreshToken).build());
        }

        return ResponseEntity.ok(
                ApiClientResponse.builder()
                        .statusCode(SuccessCode.UNAUTHORIZED.getCode())
                        .message(SuccessCode.UNAUTHORIZED.getMessage())
                        .data(null).build());
    }

    @GetMapping("/tokenCheck")
    public ResponseEntity<ApiClientResponse<?>> isLogin(String token) {
        return ResponseEntity.ok(
                ApiClientResponse.builder()
                        .statusCode(SuccessCode.OK.getCode())
                        .message(SuccessCode.OK.getMessage())
                        .data(jwtService.verifyToken(token)).build());
    }

}
