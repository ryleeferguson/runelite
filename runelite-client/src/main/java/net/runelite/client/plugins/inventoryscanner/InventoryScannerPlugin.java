package net.runelite.client.plugins.inventoryscanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.Point;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@PluginDescriptor(
        name = "Inventory Scanner",
        description = "Scans inventory and stores info in a JSON file"
)

public class InventoryScannerPlugin extends Plugin {
    @Inject
    private Client client;

    ObjectMapper mapper = new ObjectMapper();

    SlotItems slotItems = new SlotItems();

    InventoryData inventoryData = new InventoryData();

    boolean inventoryHidden = true;

    boolean inventoryInit = false;

    @Subscribe
    public void onGameTick(GameTick event){
        if(!inventoryInit){
            Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
            Point rawInventoryPoint = inventory.getCanvasLocation();
            if(rawInventoryPoint.getX() > 100){
                updateInventoryMap();
                updateInventoryData();
            }
        }
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
        {
            return;
        }

        updateInventoryMap();
        updateInventoryData();
    }

    public void updateInventoryData(){
        Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
        Collection<WidgetItem> items = inventory.getWidgetItems();

        // clear items
        inventoryData.inventory.clear();

        // populate items
        for (WidgetItem item : items) {
            if(item == null){
                continue;
            }

            Slot slot = new Slot(item.getId(), item.getIndex());
            if(slotItems.foodItems.containsKey(item.getId())){
                slot.type = SlotType.FOOD;
                slot.quantity = slotItems.foodItems.get(item.getId()).getHealAmount();
            }
            if(slotItems.prayerItems.containsKey(item.getId())){
                slot.type = SlotType.PRAYER;
                slot.quantity = slotItems.prayerItems.get(item.getId()).getRestoreAmount(client);
            }

            inventoryData.inventory.put(item.getIndex(), slot);

//            try {
//                System.out.println(mapper.writeValueAsString(slot));
//            }catch(JsonProcessingException e){
//                e.printStackTrace();
//            }
        }
        try {
            String json = mapper.writeValueAsString(inventoryData);
            writeInventoryData(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateInventoryMap(){
        Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

        Point rawInventoryPoint = inventory.getCanvasLocation();
        if(rawInventoryPoint.getX() > 100){
            inventoryInit = true;
        }
        Point inventoryPoint = new Point(rawInventoryPoint.getX() + 4, rawInventoryPoint.getY() + 27);
        // System.out.println("Inventory actual location: " + Double.toString(inventoryPoint.getX()) + ","  + Double.toString(inventoryPoint.getY()));
        Map<String, Object> slotMap = new HashMap();
        Map<String, Object> inventorySlots = new HashMap();

        int index = 0;
        for (int i = 0; i < 7; i++){
            int y = inventoryPoint.getY() + (i * 31) + (i * 5);

            for (int j = 0; j < 4; j++){
                int x = inventoryPoint.getX() + (j * 31) + (j * 10);

                Map<String, Integer> slot = new HashMap();
                slot.put("x", x);
                slot.put("y", y);

                inventorySlots.put(Integer.toString(index), slot);

                index++;
            }
        }
        slotMap.put("inventory", inventorySlots);

        try {
            String json = mapper.writeValueAsString(slotMap);
            writeSlotData(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onWidgetHiddenChanged(WidgetHiddenChanged event){
        Widget widget = event.getWidget();
        if(widget.getId() != 10747975 && widget.getType() != WidgetType.INVENTORY){
            return;
        }

        Widget inventory = client.getWidget(WidgetID.INVENTORY_GROUP_ID, 0);

        // check if inventory changed hidden or not
        if(
                (inventory.isHidden() && !inventoryHidden) ||
                (!inventory.isHidden() && inventoryHidden)
        ){
            inventoryHidden = inventory.isHidden();
            inventoryHiddenChanged();
            return;
        }
    }

    public void inventoryHiddenChanged(){
        Widget inventory = client.getWidget(WidgetID.INVENTORY_GROUP_ID, 0);

        // System.out.println("Inventory hidden changed");
    }

    public void writeInventoryData(String jsonString) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\dev\\RuneLite\\barrowshelper\\inventoryData.json");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(jsonString);
        printWriter.close();
    }

    public void writeSlotData(String jsonString){
        try {
            FileWriter fileWriter = new FileWriter("C:\\dev\\RuneLite\\barrowshelper\\slotMap.json");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(jsonString);
            printWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static boolean HasPrayerItem(Client client){
        Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
        Collection<WidgetItem> items = inventory.getWidgetItems();
        SlotItems slotItems = new SlotItems();

        // populate items
        for (WidgetItem item : items) {
            if(item == null){
                continue;
            }

            if(slotItems.prayerItems.containsKey(item.getId())){
                return true;
            }
        }

        return false;
    }
}
