package com.example.timetable.app.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({ "/timetable" })
public class JwtController {

    @Autowired
    private MyUserDetailsService DetailService;


    @Autowired
    private JwtUtil jwtutility;


    @Autowired
    private AuthenticationManager authenticationManager;



    @GetMapping("/")
    public String home () {
        return "Belcome to NT Tutorial";

    }


    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(@Valid  @RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getUserPassword()
                    )
            );


        } catch (BadCredentialsException e) {
           // authenticationEntryPoint.commence(request, response, authenticationException);

            throw new BadCredentialsException("Invalid Credentials 3333", e);
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }
        catch (AuthenticationException e){
            throw new UsernameNotFoundException("hayuko");
        }

        final UserDetails userDetails = DetailService.loadUserByUsername(jwtRequest.getUserName());

        if(userDetails == null){
           // throw new UsernameNotFoundException("Hapatikani");
        }

        final String token = jwtutility.generateToken(userDetails);


        return  ResponseEntity.ok()
                .body(new JwtResponse(token));


    }

}