package com.laibold.roadtrippackliste.controller;

import com.laibold.roadtrippackliste.model.packingList.SharedPackingList;
import com.laibold.roadtrippackliste.model.packingList.item.SharedItem;
import com.laibold.roadtrippackliste.model.requests.packingList.CheckItemRequest;
import com.laibold.roadtrippackliste.service.SharedPackingListService;
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
    private TripService tripService;

    @PostMapping("/shared/{tripId}/add")
    @ResponseBody
    public SharedPackingList addToSharedPackingList(
            @PathVariable long tripId, @RequestBody SharedItem item) {
        return sharedPackingListService.addItem(tripId, item);
    }

    @PostMapping("/shared/remove/{itemId}")
    public void RemoveFromSharedPackingList(@PathVariable long itemId) {
        sharedPackingListService.removeItem(itemId);
    }

    @PostMapping("/shared/set-checked/{itemId}")
    @ResponseBody
    public SharedItem CheckSharedItem(@PathVariable long itemId, @RequestBody CheckItemRequest request) {
        return sharedPackingListService.setChecked(itemId, request);
    }

}
