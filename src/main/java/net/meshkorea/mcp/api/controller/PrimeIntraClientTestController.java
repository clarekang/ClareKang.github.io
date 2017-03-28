package net.meshkorea.mcp.api.controller;

import com.meshprime.api.client.model.Bank;
import net.meshkorea.mcp.api.service.PrimeIntraClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Controller
@RequestMapping(value = "/intra")
public class PrimeIntraClientTestController {

    @Autowired
    PrimeIntraClientTestService primeIntraClientTestService;

    @RequestMapping(value = "/getBanks", method = RequestMethod.GET)
    public @ResponseBody
    List<Bank> getBanks() throws Exception {
        return primeIntraClientTestService.getBanks();
    }
}
