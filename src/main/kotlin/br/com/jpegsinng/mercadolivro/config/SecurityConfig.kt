package br.com.jpegsinng.mercadolivro.config

import br.com.jpegsinng.mercadolivro.repository.CustomerRepository
import br.com.jpegsinng.mercadolivro.security.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerRepository: CustomerRepository
) {

    private val PUBLIC_MATCHERS = arrayOf<String>()
    private val PUBLIC_POST_MATCHERS = arrayOf("/customer")


    @Bean
    fun filterChain(
        http: HttpSecurity,
        authManager: AuthenticationManager
    ): SecurityFilterChain {
        val authenticationFilter = AuthenticationFilter(authManager, customerRepository)
        return http
            .cors {}
            .csrf { it.disable() }
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers(*PUBLIC_MATCHERS).permitAll()
                auth.requestMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
                    .anyRequest().authenticated()
                http.addFilter(authenticationFilter)
            }.build()
    }

    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}