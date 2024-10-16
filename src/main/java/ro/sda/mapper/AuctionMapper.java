package ro.sda.mapper;


import ro.sda.dto.request.auction.AuctionRequest;
import ro.sda.dto.response.auction.AuctionResponse;
import ro.sda.entity.Auction;

public class AuctionMapper {
    public static Auction toEntity(AuctionRequest auctionRequest) {
        if (auctionRequest == null) {
            return null;
        }
        Auction auction = new Auction();
        auction.setTitle(auctionRequest.getTitle());
        auction.setDescription(auctionRequest.getDescription());
        auction.setLocation(auctionRequest.getLocation());
        auction.setCategory(auctionRequest.getCategory());
        auction.setMinimumAmount(auctionRequest.getMinimumAmount());
        auction.setEndDate(auctionRequest.getEndDate());
        return auction;
    }
    public static AuctionResponse toResponse(Auction auction) {
        if (auction == null) {
            return null;
        }
        AuctionResponse auctionResponse = new AuctionResponse();
        auctionResponse.setTitle(auction.getTitle());
        auctionResponse.setDescription(auction.getDescription());
        auctionResponse.setLocation(auction.getLocation());
        auctionResponse.setCategory(auction.getCategory());
        auctionResponse.setMinimumAmount(auction.getMinimumAmount());
        auctionResponse.setEndDate(auction.getEndDate());
        return auctionResponse;
    }
    public void updateEntityFromRequest(AuctionRequest auctionRequest, Auction auction) {
        if (auctionRequest != null) {
            auction.setTitle(auctionRequest.getTitle());
            auction.setCategory(auctionRequest.getCategory());
            auction.setMinimumAmount(auctionRequest.getMinimumAmount());
            auction.setEndDate(auctionRequest.getEndDate());
        }
    }
}
