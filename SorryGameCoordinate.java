// Assume 895x895 board
// Regular board has 4 sides x 14 edges + 4 corners = 60 squares
// Number from 0-59, edges 0...15, 15...30, 30...45, 45...0
// As Greenfoot suggests, (0,0) is the top left 

public class SorryGameCoordinate {
        private static final int B = 895;
        private static final int MARGIN = 50;
        private static final int BLENGTH = B - 2*MARGIN; // = 795 here
        private static final int BOUND = B - MARGIN; // = 845 here
        
        private static final int BSQUARES = 60;
        private static final int BROWSQUARES = BSQUARES/4; // = 15 here
        private static final int STEP = BLENGTH/BROWSQUARES; // = 53 here
        private static final int HALF = STEP/2; // = 26 here
        private static final int BNEAR = MARGIN + HALF; // = 76 here
        private static final int BFAR = B - BNEAR; // = 819 here
        
        private static final int s3 = 2*BROWSQUARES; // = 30 here
        private static final int s4 = 3*BROWSQUARES; // = 45 here
    
        public static int getCoordinate(SorryGamePiece p) {
            int x = p.getX();
            int y = p.getY();
            
            // Corners
            if (x == MARGIN && y == MARGIN) {
                return 0;
            }
            else if (x == BOUND && y == MARGIN) {
                return BROWSQUARES;
            }
            else if (x == BOUND && y == BOUND) {
                return s3;
            }
            else if (x == MARGIN && y == BOUND) {
                return s4;
            }
            
            // Starts
            else if (x == 605 && y == 730) {
                return -1;
            }
            else if (x == 660 && y == 730) {
                return -2;
            }
            else if (x == 605 && y == 785) {
                return -3;
            }
            else if (x == 660 && y == 785) {
                return -4;
            }
            else if (x == 115 && y == 605) {
                return -11;
            }
            else if (x == 170 && y == 605) {
                return -12;
            }
            else if (x == 115 && y == 660) {
                return -13;
            }
            else if (x == 170 && y == 660) {
                return -14;
            }
            else if (x == 235 && y == 115) {
                return -21;
            }
            else if (x == 290 && y == 115) {
                return -22;
            }
            else if (x == 235 && y == 170) {
                return -23;
            }
            else if (x == 290 && y == 170) {
                return -24;
            }
            else if (x == 730 && y == 235) {
                return -31;
            }
            else if (x == 785 && y == 235) {
                return -32;
            }
            else if (x == 730 && y == 290) {
                return -33;
            }
            else if (x == 785 && y == 290) {
                return -34;
            }
            
            // Safety Zones
            else if (x == 739 && y == 792) {
                return -49;
            }
            else if (x == 739 && y == 739) {
                return -48;
            }
            else if (x == 739 && y == 686) {
                return -47;
            }
            else if (x == 739 && y == 633) {
                return -46;
            }
            else if (x == 739 && y == 580) {
                return -45;
            }
            else if (x == 103 && y == 739) {
                return -59;
            }
            else if (x == 156 && y == 739) {
                return -58;
            }
            else if (x == 209 && y == 739) {
                return -57;
            }
            else if (x == 262 && y == 739) {
                return -56;
            }
            else if (x == 315 && y == 739) {
                return -55;
            }
            else if (x == 156 && y == 103) {
                return -69;
            }
            else if (x == 156 && y == 156) {
                return -68;
            }
            else if (x == 156 && y == 209) {
                return -67;
            }
            else if (x == 156 && y == 262) {
                return -66;
            }
            else if (x == 156 && y == 315) {
                return -65;
            }
            else if (x == 792 && y == 156) {
                return -79;
            }
            else if (x == 739 && y == 156) {
                return -78;
            }
            else if (x == 686 && y == 156) {
                return -77;
            }
            else if (x == 633 && y == 156) {
                return -76;
            }
            else if (x == 580 && y == 156) {
                return -75;
            }
            
            // Homes
            else if (x == 710 && y == 460) {
                return -44;
            }
            else if (x == 765 && y == 460) {
                return -43;
            }
            else if (x == 710 && y == 515) {
                return -42;
            }
            else if (x == 765 && y == 515) {
                return -41;
            }
            else if (x == 385 && y == 710) {
                return -54;
            }
            else if (x == 440 && y == 710) {
                return -53;
            }
            else if (x == 385 && y == 765) {
                return -52;
            }
            else if (x == 440 && y == 765) {
                return -51;
            }
            else if (x == 135 && y == 385) {
                return -64;
            }
            else if (x == 190 && y == 385) {
                return -63;
            }
            else if (x == 135 && y == 440) {
                return -62;
            }
            else if (x == 190 && y == 440) {
                return -61;
            }
            else if (x == 460 && y == 135) {
                return -74;
            }
            else if (x == 515 && y == 135) {
                return -73;
            }
            else if (x == 460 && y == 190) {
                return -72;
            }
            else if (x == 515 && y == 190) {
                return -71;
            }
            
            
            // Edges
            else if (y <= BNEAR) {
                return x / STEP;
            }
            else if (x >= BFAR) {
                return BROWSQUARES + y / STEP;
            }
            else if (y >= BFAR) {
                return s4 - (x / STEP);
            }
            else if (x <= BNEAR) {
                return BSQUARES - (y / STEP);
            }
            
            return 0; // Should not reach this point
        }
    
        // Go to coordinate destination d -> p to (x, y)
        public static void movement(SorryGamePiece p, int d) {
            if (d >= 0 && d <= 15) {
                p.setLocation(MARGIN + STEP*d, MARGIN);
            }
            else if (d > 15 && d <= 30) {
                p.setLocation(BOUND, MARGIN + STEP*(d-BROWSQUARES));
            }
            else if (d > 30 && d <= 45) {
                p.setLocation(BOUND - STEP*(d-s3), BOUND);
            }
            else if (d > 45 && d < 60) {
                p.setLocation(MARGIN, BOUND - STEP*(d-s4));
            }
            // Starts
            else if (d == -1) {
                p.setLocation(605, 730);
            }
            else if (d == -2) {
                p.setLocation(660, 730);
            }
            else if (d == -3) {
                p.setLocation(605, 785);
            }
            else if (d == -4) {
                p.setLocation(660, 785);
            }
            else if (d == -11) {
                p.setLocation(115, 605);
            }
            else if (d == -12) {
                p.setLocation(170, 605);
            }
            else if (d == -13) {
                p.setLocation(115, 660);
            }
            else if (d == -14) {
                p.setLocation(170, 660);
            }
            else if (d == -21) {
                p.setLocation(235, 115);
            }
            else if (d == -22) {
                p.setLocation(290, 115);
            }
            else if (d == -23) {
                p.setLocation(235, 170);
            }
            else if (d == -24) {
                p.setLocation(290, 170);
            }
            else if (d == -31) {
                p.setLocation(730, 235);
            }
            else if (d == -32) {
                p.setLocation(785, 235);
            }
            else if (d == -33) {
                p.setLocation(730, 290);
            }
            else if (d == -34) {
                p.setLocation(785, 290);
            }
            // Safety Zones
            else if (d > -50 && d <= -45) {
                p.setLocation(739, 792 - STEP*(d+49));
            }    
            else if (d > -60 && d <= -55) {
                p.setLocation(103 + STEP*(d+59), 739);
            }
            else if (d > -70 && d <= -65) {
                p.setLocation(156, 103 + STEP*(d+69));
            }
            else if (d > -80 && d <= -75) {
                p.setLocation(792 - STEP*(d+79), 156);
            }
            // Homes
            else if (d == -44) {
                p.setLocation(710, 460);
            }
            else if (d == -43) {
                p.setLocation(765, 460);
            }
            else if (d == -42) {
                p.setLocation(710, 515);
            }
            else if (d == -41) {
                p.setLocation(765, 515);
            }
            else if (d == -54) {
                p.setLocation(385, 710);
            }
            else if (d == -53) {
                p.setLocation(440, 710);
            }
            else if (d == -52) {
                p.setLocation(385, 765);
            }
            else if (d == -51) {
                p.setLocation(440, 765);
            }
            else if (d == -64) {
                p.setLocation(135, 385);
            }
            else if (d == -63) {
                p.setLocation(190, 385);
            }
            else if (d == -62) {
                p.setLocation(135, 440);
            }
            else if (d == -61) {
                p.setLocation(190, 440);
            }
            else if (d == -74) {
                p.setLocation(460, 135);
            }
            else if (d == -73) {
                p.setLocation(515, 135);
            }
            else if (d == -72) {
                p.setLocation(460, 190);
            }
            else if (d == -71) {
                p.setLocation(515, 190);
            }
        }
    }
