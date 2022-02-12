import com.asgarov.ChairWarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChairWarehouseTest {

    @Test
    public void setInitialStockTo37() {
        ChairWarehouse.getInstance();
        ChairWarehouse.getInstance().buyStockForChairWarehouse(37);
        assertEquals(37, ChairWarehouse.getInstance().getCurrentStockQuantity());
    }


    @Test
    public void testTheLeftoverStockToBe7() throws InterruptedException {
        ChairWarehouse.getInstance();
        ChairWarehouse.getInstance().buyStockForChairWarehouse(37);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ChairWarehouse.getInstance().sellChairFromStock(3);
                System.out.println(ChairWarehouse.getInstance().getCurrentStockQuantity());
            }).start();
        }
        Thread.sleep(200);
        assertEquals(7, ChairWarehouse.getInstance().getCurrentStockQuantity());
    }
}
