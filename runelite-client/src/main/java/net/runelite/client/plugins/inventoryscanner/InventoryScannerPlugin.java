package net.runelite.client.plugins.inventoryscanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;

@PluginDescriptor(
        name = "Inventory Scanner",
        description = "Scans inventory and stores info in a JSON file"
)

public class InventoryScannerPlugin extends Plugin {
    @Inject
    private Client client;

    ObjectMapper mapper = new ObjectMapper();

    SlotItems slotItems = new SlotItems();

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
        {
            return;
        }

        InventoryData inventoryData = new InventoryData();

        Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
        Collection<WidgetItem> items = inventory.getWidgetItems();

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

            try {
                System.out.println(mapper.writeValueAsString(slot));
            }catch(JsonProcessingException e){
                e.printStackTrace();
            }
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

    public void writeInventoryData(String jsonString) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\dev\\Rylee\\rs\\barrowsHelper\\inventoryData.json");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(jsonString);
        printWriter.close();
    }
}
