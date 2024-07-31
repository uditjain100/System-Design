package Scenarios.Parking.enums;

public enum SlotType {

    SMALL {
        @Override
        public int getCostPerHour() {
            return 10;
        }
    },
    MEDIUM {
        @Override
        public int getCostPerHour() {
            return 20;
        }
    },
    LARGE {
        @Override
        public int getCostPerHour() {
            return 30;
        }
    };

    public abstract int getCostPerHour();
}
