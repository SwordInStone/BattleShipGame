package app;

public enum Commands {
    START("/start", "Начать игру", 3, 4),
    END("/end", "Завершить игру", 0, 1),
    CONNECTION_HOST("/host", "Стать хостом", 1, 3),
    CONNECTION_CLIENT("/client", "Стать клиентом", 1, 2),
    CONNECT("/connect x.x.x.x", "Подключиться к хосту по ip x.x.x.x", 2, 4),
    SHOOT("/shoot x y", "Выстрелить по координатам x y", 4, 4),
    UNKNOWN("", "Команда не существует", -1, 1);

    private String command;
    private String description;
    private int used_step;
    private int next_step;

    Commands(String command, String description, int used_step, int next_step)
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
            if (c.command.equals(command)) {
                return c;
            }
        }
        return Commands.UNKNOWN;
    }

    public boolean isAvailable(int step) {
        boolean b = step == this.used_step || step == 0;
        return b;
    }

}
