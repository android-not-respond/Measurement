/**
 * Here we present our monitor infrastructure implemented in Android-MOD.
 * Basically, we collect multiple logs upon the occurrence of ANR/SNR.
 */
public class Monitor {

    // A set of important system services
    String[] servicesOfInterest = {
            "SystemServer",
            "MediaServer",
            "Vold",
    };

    /**
     * Collect the call stacks of a designated process.
     *
     * @param pid The process' ID.
     * @param tracesPath The path of collected call stacks.
     */
    void collectCallStacks(int pid, String tracesPath) {
        // Collect the call stacks of the Android framework layer
        dumpStackTraces(pid, tracesPath);
        // Collect the call stacks of the Android native layer
        dumpNativeBacktraceToFile(pid, tracesPath);
        // Collect the call stacks of the Android kernel
        native_dumpKernelStacks(tracesPath);
    }

    /**
     * Collect all logs that we deem necessary
     *
     * @param pid The process' ID.
     * @param tracesPath The path of collected call stacks.
     */
    void collectLogs (int pid, String tracesPath) {
        collectCallStacks(pid, tracesPath);

        // Collect the call stacks of several important system services
        for (String services : servicesOfInterest) {
            collectCallStacks(getPid(services), tracesPath);
        }

        // Collect CPU/Memory usage
        collectCPUMemory();
        // Collect Android's event logs
        collectEventLogs();
    }
}
