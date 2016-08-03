package com.instantcredit.controller;

import com.instantcredit.controller.dto.DecipherInput;
import com.instantcredit.service.DecipherService;
import com.instantcredit.service.JsonSerializer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("decipher")
public class DecipherController {

    private static final String DECIPHER_TIME_CONSUMPTION = "Decipher time consumption: ";
    private static final String DECIPHER_TEXT = "Decipher: ";
    private static final String ERROR = "Error:";
    private static final String INPUT_NOT_VALID = "The input is not valid";
    private DecipherService decipherService = new DecipherService();

    private static final Logger LOG = Logger.getLogger(CipherController.class.getName());


    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response decipher(DecipherInput decipherInput) throws Throwable {

        long startTime = System.nanoTime();

        String output = INPUT_NOT_VALID;
        boolean valid = validateInput(decipherInput.getText());

        if (valid) {
            output = decipherService.decrypt(decipherInput.getText());
            String json = JsonSerializer.serializeString(DECIPHER_TEXT, output);

            long estimatedTime = System.nanoTime() - startTime;
            LOG.info(DECIPHER_TIME_CONSUMPTION + estimatedTime);

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
