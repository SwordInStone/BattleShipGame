package app;

public enum Commands {
    START("/start", "������ ����", 3, 4),
    END("/end", "��������� ����", 0, 1),
    CONNECTION_HOST("/host", "����� ������", 1, 3),
    CONNECTION_CLIENT("/client", "����� ��������", 1, 2),
    CONNECT("/connect x.x.x.x", "������������ � ����� �� ip x.x.x.x", 2, 4),
    SHOOT("/shoot x y", "���������� �� ����������� x y", 4, 4),
    UNKNOWN("", "������� �� ����������", -1, 1);

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
