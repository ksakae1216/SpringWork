package jp.org.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.org.web.login.service.UserDetailsServiceImpl;
/**
 * Spring Security設定クラス.
 */
@Configuration
@EnableWebSecurity   // Spring Securityの基本設定
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers(
                            "/images/**",
                            "/css/**",
                            "/javascript/**",
                            "/webjars/**");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認可の設定
        http.authorizeRequests()
            .antMatchers("/", "/login").permitAll() // loginは全ユーザーアクセス許可
            .anyRequest().authenticated();  // それ以外は全て認証無しの場合アクセス不許可

        // ログイン設定
        http.formLogin()
            .loginProcessingUrl("/doLogin")   // 認証処理のパス
            .loginPage("/login")            // ログインフォームのパス
//            .failureHandler(new SampleAuthenticationFailureHandler())       // 認証失敗時に呼ばれるハンドラクラス
            .defaultSuccessUrl("/menu")     // 認証成功時の遷移先
            .usernameParameter("login_id").passwordParameter("login_password")  // ユーザー名、パスワードのパラメータ名
            .and();

        // ログアウト設定
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))       // ログアウト処理のパス
            .logoutSuccessUrl("/login");                                        // ログアウト完了時のパス

    }
	
//	@Configuration
//    protected static class AuthenticationConfiguration
//    extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        UserDetailsServiceImpl userDetailsService;
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            // 認証するユーザーを設定する
//            auth.userDetailsService(userDetailsService)
//            // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
//            .passwordEncoder(new BCryptPasswordEncoder());
//
//        }
//    }
}
