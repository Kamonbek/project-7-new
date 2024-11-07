@256
D=A
@SP
M=D
// call Sys.init 0
@SP
D=M
@R13
M=D
@RETURN_ADDRESS0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@R13
D=M
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(RETURN_ADDRESS0)
// C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq
D=M
A=A-1
D=M-D
M=-1
@END1
D;JEQ
@SP
A=M-1
M=0
(END1)
// C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 16
@16
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq
D=M
A=A-1
D=M-D
M=-1
@END2
D;JEQ
@SP
A=M-1
M=0
(END2)
// C_PUSH constant 16
@16
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq
D=M
A=A-1
D=M-D
M=-1
@END3
D;JEQ
@SP
A=M-1
M=0
(END3)
// C_PUSH constant 892
@892
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt
D=M
A=A-1
D=M-D
M=-1
@END4
D;JLT
@SP
A=M-1
M=0
(END4)
// C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 892
@892
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt
D=M
A=A-1
D=M-D
M=-1
@END5
D;JLT
@SP
A=M-1
M=0
(END5)
// C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt
D=M
A=A-1
D=M-D
M=-1
@END6
D;JLT
@SP
A=M-1
M=0
(END6)
// C_PUSH constant 32767
@32767
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt
D=M
A=A-1
D=M-D
M=-1
@END7
D;JGT
@SP
A=M-1
M=0
(END7)
// C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 32767
@32767
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt
D=M
A=A-1
D=M-D
M=-1
@END8
D;JGT
@SP
A=M-1
M=0
(END8)
// C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt
D=M
A=A-1
D=M-D
M=-1
@END9
D;JGT
@SP
A=M-1
M=0
(END9)
// C_PUSH constant 57
@57
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 31
@31
D=A
@SP
A=M
M=D
@SP
M=M+1
// C_PUSH constant 53
@53
D=A
@SP
A=M
M=D
@SP
M=M+1
// add
D=M
A=A-1
M=M+D
// C_PUSH constant 112
@112
D=A
@SP
A=M
M=D
@SP
M=M+1
// sub
D=M
A=A-1
M=M+D
// neg
M=-M
// and
D=M
A=A-1
M=M+D
// C_PUSH constant 82
@82
D=A
@SP
A=M
M=D
@SP
M=M+1
// or
D=M
A=A-1
M=M+D
// not
M=!M
