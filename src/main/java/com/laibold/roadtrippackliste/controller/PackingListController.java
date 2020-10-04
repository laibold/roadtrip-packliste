package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.model.traveller.Traveller;
import com.laibold.roadtrippackliste.service.SharedPackingListService;
import com.laibold.roadtrippackliste.service.TravellerPackingListService;
import com.laibold.roadtrippackliste.service.TravellerService;
import com.laibold.roadtrippackliste.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("packing")
public class PackingListController {
    @Autowired
    private SharedPackingListService sharedPackingListService;

    @Autowired
    private TravellerPackingListService travellerPackingListService;

    @Autowired
    private TripService tripService;

    @PutMapping("/shared/{tripId}")
    @ResponseBody
    public SharedPackingList addToSharedPackingList(@PathVariable long tripId, @RequestBody SharedItem item) {
        return sharedPackingListService.addItem(tripId, item);
    }

    @DeleteMapping("/shared/{itemId}")
    public String RemoveFromSharedPackingList(@PathVariable long itemId) {
        return sharedPackingListService.removeItem(itemId);
    }

    @PostMapping("/shared/set-checked/{itemId}")
    @ResponseBody
    public SharedItem CheckSharedItem(@PathVariable long itemId, @RequestBody CheckItemRequest request) {
        //TODO error handling
        return sharedPackingListService.setChecked(itemId, request);
    }

    @PutMapping("/list/{tripId}/{travellerId}")
    @ResponseBody
    public TravellerPackingList addToSharedPackingList(
            @PathVariable long tripId, @PathVariable long travellerId, @RequestBody SharedItem item) {
        return travellerPackingListService.addItem(tripId, travellerId, item);
    }

}
