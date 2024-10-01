package ro.sda.service;

import ro.sda.repository.BiddingRepository;

public class BiddingService {

    private BiddingRepository biddingRepository;

    public BiddingService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }
}
