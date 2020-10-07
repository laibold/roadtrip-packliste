package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.exception.badRequest.ItemMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.RequestBodyMissingException;
import com.laibold.roadtrippackliste.model.exception.badRequest.TravellerIdMissingException;
import com.laibold.roadtrippackliste.model.exception.notFound.ItemNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.PackingListNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.SharedPackingListNotFoundException;
import com.laibold.roadtrippackliste.model.exception.notFound.TravellerNotFoundException;
import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.TravellerPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.Item;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.service.SharedPackingListService;
import com.laibold.roadtrippackliste.service.TravellerPackingListService;
import com.laibold.roadtrippackliste.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return sharedPackingListService.addItem(tripId, item);
        } catch (RequestBodyMissingException | ItemMissingException | SharedPackingListNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @DeleteMapping("/shared/{itemId}")
    public String RemoveFromSharedPackingList(@PathVariable long itemId) {
        return sharedPackingListService.removeItem(itemId);
    }

    @PostMapping("/shared/set-checked/{itemId}")
    @ResponseBody
    public SharedItem CheckSharedItem(@PathVariable long itemId, @RequestBody CheckItemRequest request) {
        try {
            return sharedPackingListService.setChecked(itemId, request);
        } catch (RequestBodyMissingException | TravellerIdMissingException |
                ItemNotFoundException | TravellerNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    //TODO get shared

    @PutMapping("/lists/{tripId}/{travellerId}")
    @ResponseBody
    public TravellerPackingList addToTravellerPackingList(
            @PathVariable long tripId, @PathVariable long travellerId, @RequestBody SharedItem item) {
        try {
            return travellerPackingListService.addItem(tripId, travellerId, item);
        } catch (RequestBodyMissingException | ItemMissingException | PackingListNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @DeleteMapping("/lists/{itemId}")
    @ResponseBody
    public String RemoveFromTravellerPackingList(@PathVariable long itemId) {
        try {
            return travellerPackingListService.removeItem(itemId);
        } catch (ItemNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    @PostMapping("/lists/set-checked/{itemId}")
    @ResponseBody
    public Item CheckTravellerItem(@PathVariable long itemId, @RequestBody CheckItemRequest request) {
        try {
            return travellerPackingListService.setChecked(itemId, request);
        } catch (RequestBodyMissingException | ItemNotFoundException ex) {
            throw new ResponseStatusException(
                    ex.getStatus(), ex.getErrorMessage(), ex
            );
        }
    }

    //TODO get travellerList

}
