package fr.associationrdj.backend.back.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtUserDetailService jwtUserDetailService;
    private JwtTokenUtil jwtTokenUtil;
    public JwtRequestFilter(JwtUserDetailService jwtUserDetailService, JwtTokenUtil jwtTokenUtil) {
        this.jwtUserDetailService = jwtUserDetailService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal (
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

        String pseudo = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try {
                pseudo = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }
            catch (IllegalArgumentException e){
                log.warn("Erreur"+jwtToken);
            }
        }
    }


}
