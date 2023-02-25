package java.app;

public enum Commands {
    START("/start", "Начать игру", 2, 3),
    END("/end", "Завершить игру", 0, 1),
    CONNECTION_HOST("/host", "Стать хостом", 1, 2),
    CONNECTION_CLIENT("/client", "Стать клиентом", 1, 2),
    SHOOT("/shoot x y", "Выстрелить по координатам x y", 3, 3),
    UNKNOWN("", "Команда не существует", -1, 1);

    private String command;
    private String description;
    private int used_step;
    private int next_step;

    private Commands(String command, String description, int used_step, int next_step)
    {
        this.command = command;
        this.description = description;
        this.used_step = used_step;
        this.next_step = next_step;
    }

    public String getName()
    {
        return this.command;
    }
    public String getDescription()
    {
        return this.description;
    }

    public static Commands getCommand(String command) {
        for (Commands c : Commands.values()) {
            if (c.getName() == command) {
                return c;
            }
        }
        return Commands.UNKNOWN;
    }

    public boolean isAvailable(int step) {
        if (step == this.used_step || step == 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
