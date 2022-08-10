package com.eunji.houseutils.controller;
import com.eunji.houseutils.constants.ActionType;
import com.eunji.houseutils.policy.BrokeragePolicy;
import com.eunji.houseutils.policy.BrokeragePolicyFactory;
import com.eunji.houseutils.policy.PurchaseBrokeragePolicy;
import com.eunji.houseutils.policy.RentBrokeragePolicy;
import com.eunji.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* 
* 중개수수료가 얼마인지 조회하는 컨트롤러
* */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {
    private final ApartmentService apartmentService;


    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                               @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/appartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(@RequestParam ActionType actionType,
                                           @PathVariable Long apartmentId) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return apartmentService.getPriceOrThrow(apartmentId);
    }
}
