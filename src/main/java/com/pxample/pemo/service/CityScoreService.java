package com.pxample.pemo.service;

import com.pxample.api.CityScore.CityScoreResponse;
import com.pxample.api.CityScore.CityScoreRequest;
import com.pxample.api.cityscoreGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class CityScoreService extends cityscoreGrpc.cityscoreImplBase {

    @Autowired
    private ValidationService validationService;

    @Override
    public void calculateCityScore (CityScoreRequest cityScoreRequest, StreamObserver<CityScoreResponse> cityScoreResponseStreamObserver) {
        System.out.println("Request received from client: \n" + cityScoreRequest);

        validationService.validateCityCode((cityScoreRequest.getCityCode()));

        Integer cityScore = cityScoreRequest.getCityCode() * 10;

        // build response
        CityScoreResponse cityScoreResponse = CityScoreResponse.newBuilder()
                .setCityScore(cityScore)
                .build();

        cityScoreResponseStreamObserver.onNext(cityScoreResponse);
        cityScoreResponseStreamObserver.onCompleted();
    }
}
