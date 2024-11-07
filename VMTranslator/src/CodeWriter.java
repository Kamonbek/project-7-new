import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter {
    private String filename;
    private PrintWriter writeOut;
    private int labelNumber;

    private void out(String line) {
        writeOut.println(line);
    }

    private String nextLabel() {
        return String.valueOf(labelNumber++);
    }

    public CodeWriter(File output) throws FileNotFoundException {
        try {
            writeOut = new PrintWriter(output);
            labelNumber = 0;
        } catch (FileNotFoundException fnf) {
            throw new FileNotFoundException("File not found: " + fnf.getMessage());
        }
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public void writeInit() {
        // TODO: set SP to 256
        out("@256");
        out("D=A");
        out("@SP");
        out("M=D");

         //uncomment in project 8
         writeCall("Sys.init", 0);
    }

    public void writeArithmetic(String operation) {
        out("// " + operation);

        switch (operation.toLowerCase()) {
            case "add":
            case "sub":
            case "and":
            case "or":
                // TODO: implement arithmetic operations
                out("D=M");
                out("A=A-1");
                out("M=M+D");


                break;
            case "eq":
            case "lt":
            case "gt":
                // TODO: implement comparison operations
                out("D=M");
                out("A=A-1");
                out("D=M-D");
                out("M=-1");
                out("@END" + labelNumber);
                out("D;J" + operation.toUpperCase());
                out("@SP");
                out("A=M-1");
                out("M=0");
                out("(END" + labelNumber + ")");
                labelNumber++;
                break;
            case "not":
                // TODO: implement not operation
                out("M=!M");
                break;
            case "neg":
                // TODO: implement negation operation
                out("M=-M");
                break;
        }
    }

    public void writePushPop(CommandType command, String segment, int index) {
        out("// " + command + " " + segment + " " + index);
        if (command == CommandType.C_PUSH) {
            // save value to D
            switch (segment.toLowerCase()) {
                case "pointer":
                    // TODO: save pointer value to D
                    out("@" + (index == 0 ? "THIS" : "THAT"));
                    out("D=M");
                    break;
                case "static":
                    // TODO: save static value to D
                    out("@" + filename + "." + index);
                    out("D=M");
                    break;
                case "constant":
                    // TODO: save constant value to D
                    out("@" + index);
                    out("D=A");
                    break;
                case "temp":
                    // TODO: save temp value to D
                    out("@" + (5 + index));
                    out("D=M");
                    break;
                default:
                    // TODO: save value from segment to D
                    out("@" + getLabel(segment));
                    out("D=M");
                    out("@" + index);
                    out("A=D+A");
                    out("D=M");
                    break;
            }

            // push D to stack
            finishPush();
        } else if (command == CommandType.C_POP) {
            // save address to D
            switch (segment.toLowerCase()) {
                case "pointer":
                    // TODO: save pointer address to D
                    out("@" + (index == 0 ? "THIS" : "THAT"));
                    out("D=A");
                    break;
                case "static":
                    // TODO: save static address to D
                    out("@" + filename + "." + index);
                    out("D=A");

                    break;
                case "temp":
                    // TODO: save temp address to D
                    out("@" + (5 + index));
                    out("D=A");

                    break;
                default:
                    // TODO: save address from segment to D
                    out("@" + getLabel(segment));
                    out("D=M");
                    out("@" + index);
                    out("D=D+A");
                    break;
            }
            // pop to an address pointed by D
            // TODO: pop to address pointed by D
            out("@R13");
            out("M=D");
            out("@SP");
            out("AM=M-1");
            out("D=M");
            out("@R13");
            out("A=M");
            out("M=D");

        }
    }

    private void finishPush() {
        // TODO: push D to stack
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");

    }

    public void writeLabel(String label) {
        out("// C_LABEL " + label);
        // TODO: write label
        out("(" + label + ")");
    }

    public void writeGoto(String label) {
        out("// C_GOTO " + label);
        // TODO: write goto
        out("@" + label);
    }

    public void writeIf(String label) {
        out("// C_IF " + label);
        // TODO: write if
        out("@SP");
        out("AM=M-1");
        out("D=M");
        out("@" + label);
        out("D;JNE");

    }

    public void writeCall(String functionName, int numArgs) {
        String label = nextLabel();

        out("// call " + functionName + " " + numArgs);
        // R13 = SP
        // TODO: store SP in R13
        out("@SP");
        out("D=M");
        out("@R13");
        out("M=D");

        // push return address
        // TODO: push return address
        out("@RETURN_ADDRESS" + label);
        out("D=A");
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");


        // push LCL
        // TODO: push LCL
        out("@LCL");
        out("D=M");
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");


        // push ARG
        // TODO: push ARG
        out("@ARG");
        out("D=M");
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");


        // push THIS
        // TODO: push THIS
        out("@THIS");
        out("D=M");
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");

        // push THAT
        // TODO: push THAT
        out("@THAT");
        out("D=M");
        out("@SP");
        out("A=M");
        out("M=D");
        out("@SP");
        out("M=M+1");

        // ARG = R13 - numArgs
        // TODO: set ARG to R13 - numArgs, where numArgs is the number of arguments and R13 is the current SP
        out("@R13");
        out("D=M");
        out("@" + numArgs);
        out("D=D-A");
        out("@ARG");
        out("M=D");

        // LCL = SP
        // TODO: set LCL to SP
        out("@SP");
        out("D=M");
        out("@LCL");
        out("M=D");


        // goto functionName
        // TODO: goto functionName
        out("@" + functionName);
        out("0;JMP");

        // declare return address label
        // TODO: declare return address label
        out("(RETURN_ADDRESS" + label + ")");
    }

    public void writeReturn() {
        out("// return");

        // store return address in R13 = LCL - 5
        // TODO: store return address in R13
        out("@LCL");
        out("D=M");
        out("@5");
        out("A=D-A");
        out("D=M");
        out("@R13");
        out("M=D");


        // store return value *(SP-1) in *ARG
        // TODO: store return value in *ARG
        out("@SP");
        out("A=M-1");
        out("D=M");
        out("@ARG");
        out("A=M");
        out("M=D");

        // restore SP = ARG + 1
        // TODO: restore SP
        out("@ARG");
        out("D=M+1");
        out("@SP");
        out("M=D");

        // restore THAT = *(LCL - 1); LCL--
        // TODO: restore THAT
        out("@LCL");
        out("AM=M-1");
        out("D=M");
        out("@THAT");
        out("M=D");


        // restore THIS = *(LCL - 1); LCL--
        // TODO: restore THIS
        out("@LCL");
        out("AM=M-1");
        out("D=M");
        out("@THIS");
        out("M=D");


        // restore ARG = *(LCL - 1); LCL--
        // TODO: restore ARG
        out("@LCL");
        out("AM=M-1");
        out("D=M");
        out("@ARG");
        out("M=D");

        // restore LCL=*(LCL - 1)
        // TODO: restore LCL
        out("@LCL");
        out("AM=M-1");
        out("D=M");
        out("@LCL");
        out("M=D");

        // Jump to return address stored in R13
        // TODO: jump to return address
        out("@R13");
        out("A=M");
        out("0;JMP");
    }

    public void writeFunction(String functionName, int numLocals) {
        writeOut.println("// function " + functionName + numLocals);

        // declare label for function entry
        // TODO: declare label for function entry
        writeOut.println("(" + functionName + ")");

        // initialize local variables to 0
        // TODO: initialize local variables to 0
        for (int i = 0; i < numLocals; i++) {
            writeOut.println("@SP");
            writeOut.println("A=M");
            writeOut.println("M=0");
            writeOut.println("@SP");
            writeOut.println("M=M+1");
        }
    }

    private String getLabel(String segment) {
        switch (segment.toLowerCase()) {
            case "local":
                return "@LCL";
            case "argument":
                return "@ARG";
            case "this":
                return "@THIS";
            case "that":
                return "@THAT";
            default:
                return null;
        }
    }

    public void close() {
        writeOut.close();
    }
}
