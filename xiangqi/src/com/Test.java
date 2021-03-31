package com;

import com.chess.*;
import com.sun.xml.internal.bind.v2.TODO;

public class Test {
    public Test(){

    }
    public static void main(String[] args) {
        Desk desk = new Desk();
        UtilsForChess.setDesk(desk);
        UtilsForChess.showDesk(desk);
        String s = "c3c4b7c7h2e2h7e7h0g2h9g7i0h0b9a7b2d2a9b9b0c2b9b3g3g4b3c3c0a2c6c5c4c5c3c5c2d4i9i8a0b0i8f8d0e1a6a5h0h6f9e8h6g6g9i7b0b6f8f1e2e6g7e6g6e6e7g7e6g6g7g9d2d1f1f7g0e2c5c1d1d2c1c3b6b3c3c5a2c0c7d7d4e6c5c6e6f4c6c5b3b6f7f5b6f6d7f7f4d3f5f6g6f6c5c3d3e5g9g2d2g2c3e3e5f7e8f7f6f7e3i3f7i7d9e8i7c7a7b5c7c9e8d9c9c5b5a3c5a5i3b3a5h5d9e8g4g5b3g3g2f2a3b5g5f5";
        s = "h0i2c6c5i0i1b9c7i1d1i6i5d1d4h9i7c3c4c5c4d4c4c9e7c0e2i9i8d0e1b7b9b2c2b9c9c4b4i8d8c2c9a9c9b0c2d8d3a0d0d3c3d0d4d9e8i3i4i5i4d4i4c7d5b4d4c9c5i4e4h7h6d4c4c5c4e4c4c3c4e2c4g6g5h2e2i7g6i2h4h6h5h4i2d5f4e3e4e6e5e4e5g6e5c4a2e5d3e2d2h5h2g0e2h2d2e1d2f4e2f0e1a6a5a2c0e2f4c2d4f4d5c0e2d5f4i2g1";
        UtilsForChess.autoReadICCS(s,desk);
        UtilsForChess.showDesk(desk);
    }
    public void test(){
        Desk desk = new Desk();
        UtilsForChess.setDesk(desk);
        UtilsForChess.showDesk(desk);
        String s = "c3c4b7c7h2e2h7e7h0g2h9g7i0h0b9a7b2d2a9b9b0c2b9b3g3g4b3c3c0a2c6c5c4c5c3c5c2d4i9i8a0b0i8f8d0e1a6a5h0h6f9e8h6g6g9i7b0b6f8f1e2e6g7e6g6e6e7g7e6g6g7g9d2d1f1f7g0e2c5c1d1d2c1c3b6b3c3c5a2c0c7d7d4e6c5c6e6f4c6c5b3b6f7f5b6f6d7f7f4d3f5f6g6f6c5c3d3e5g9g2d2g2c3e3e5f7e8f7f6f7e3i3f7i7d9e8i7c7a7b5c7c9e8d9c9c5b5a3c5a5i3b3a5h5d9e8g4g5b3g3g2f2a3b5g5f5";
        s = "h0i2c6c5i0i1b9c7i1d1i6i5d1d4h9i7c3c4c5c4d4c4c9e7c0e2i9i8d0e1b7b9b2c2b9c9c4b4i8d8c2c9a9c9b0c2d8d3a0d0d3c3d0d4d9e8i3i4i5i4d4i4c7d5b4d4c9c5i4e4h7h6d4c4c5c4e4c4c3c4e2c4g6g5h2e2i7g6i2h4h6h5h4i2d5f4e3e4e6e5e4e5g6e5c4a2e5d3e2d2h5h2g0e2h2d2e1d2f4e2f0e1a6a5a2c0e2f4c2d4f4d5c0e2d5f4i2g1";
        UtilsForChess.autoReadICCS(s,desk);
        UtilsForChess.showDesk(desk);
    }
}
