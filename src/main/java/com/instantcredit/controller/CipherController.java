package com.instantcredit.controller;


import com.instantcredit.controller.dto.CipherInput;
import com.instantcredit.service.CipherService;
import com.instantcredit.service.JsonSerializer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("cipher")
public class CipherController {

    private static final String CIPHER_TIME_CONSUMPTION = "Cipher time consumption: ";
    private static final String CIPHER_TEXT = "Cipher: ";
    private static final String ERROR = "Error:";
    private static final String INPUT_NOT_VALID = "The input is not valid";
    private CipherService cipherService = new CipherService();

    private static final Logger LOG = Logger.getLogger(CipherController.class.getName());

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response cipher(CipherInput cipherInput) throws Throwable {

        long startTime = System.nanoTime();

        String output = INPUT_NOT_VALID;
        boolean valid = validateInput(cipherInput.getText());

        if (valid) {
            output = cipherService.encrypt(cipherInput.getText());
            String json = JsonSerializer.serializeString(CIPHER_TEXT, output);

            long estimatedTime = System.nanoTime() - startTime;
            LOG.info(CIPHER_TIME_CONSUMPTION + estimatedTime);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(JsonSerializer.serializeString(ERROR, output)).build();
        }
    }

    private boolean validateInput(String text) {
        //Todo validation
        return true;
    }

}
