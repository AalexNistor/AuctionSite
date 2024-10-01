package ro.sda.service;

import ro.sda.repository.AuctionRepository;

public class AuctionService {

    private AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }
}
