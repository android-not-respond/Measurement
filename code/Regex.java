public class Regex {
    // Kernel regex
    public static final String EXP_KERNEL_START_STRING = "Internal error: Oops,Kernel BUG,Kernel panic,Watchdog bark,watchdog bite";
    public static final String EXP_KERNEL_END_STRING = "---,end trace,===,PC: 0x";
    public static final String EXP_KERNEL_START = "exp_ke_start";
    public static final String EXP_KERNEL_END = "exp_ke_end";
    public static final String REGEX_ADDRESS = "(\\+)?0x[0-9a-fA-F]{1,10}(/0x)?[0-9a-fA-F]{1,10}";
    public static final String REGEX_USELESS_INFO = "\\[[a-zA-Z]+/[0-9]:[0-9]:[0-9]+]";
    public static final String REGEX_VIRTUAL_ADDRESS = "address [0-9a-fA-F]{1,16}";
    public static final String REGEX_PROCESS = "([a-zA-Z])\\d+:\\d";
    public static final String REGEX_BUG_AT_ADDRESS = "(Kernel BUG at )[0-9a-fA-F]{1,16}";

    // Native regex
    public static final String REGEX_PC = " *#\\d+ pc [0-f]{1,16} ";
    public static final String REGEX_OFFSET = "offset 0x[0-f]{1,16}";
    public static final String REGEX_NUMBER = "\\d+";
    public static final String REGEX_FLG = "0x[0-9a-fA-F]{1,10}";

    // Java regex
    public static final String REGEX_TID = "tid=\\d+";
    public static final String REGEX_LINE_NUMBER = ":\\d+)";
    public static final String REGEX_ADDR = "#\\d+ pc [0-9a-fA-F]+ ";
    public static final String REGEX_LOCK = "0x[0-9a-fA-F]+";
    public static final String REGEX_LOCK_ADDR = "<@addr=0x[0-9a-fA-F]{1,30}>";
    public static final String REGEX_$ = "$[0-9a-fA-F]{1,10}";
    public static final String REGEX_AT = "@[0-9a-fA-F]{1,10}";
    public static final String REGEX_NUM = "\\d+";
    public static final String REGEX = REGEX_ADDR + "|" + REGEX_LOCK + "|"
            + REGEX_LOCK_ADDR + "|" + REGEX_$ + "|" + REGEX_AT;
}
