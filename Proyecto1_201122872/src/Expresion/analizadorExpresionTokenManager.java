/* analizadorExpresionTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. analizadorExpresionTokenManager.java */
package Expresion;
import java.io.*;

/** Token Manager. */
@SuppressWarnings("unused")public class analizadorExpresionTokenManager implements analizadorExpresionConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x80000000L) != 0L)
            return 4;
         if ((active0 & 0x3800000L) != 0L)
         {
            jjmatchedKind = 40;
            return 9;
         }
         if ((active0 & 0x100000000L) != 0L)
            return 40;
         return -1;
      case 1:
         if ((active0 & 0x3800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
            return 9;
         }
         return -1;
      case 2:
         if ((active0 & 0x3800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 2;
            return 9;
         }
         return -1;
      case 3:
         if ((active0 & 0x1800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 3;
            return 9;
         }
         if ((active0 & 0x2000000L) != 0L)
            return 9;
         return -1;
      case 4:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 4;
            return 9;
         }
         if ((active0 & 0x1000000L) != 0L)
            return 9;
         return -1;
      case 5:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 5;
            return 9;
         }
         return -1;
      case 6:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 6;
            return 9;
         }
         return -1;
      case 7:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 7;
            return 9;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 2;
         return jjMoveStringLiteralDfa1_0(0x10L);
      case 33:
         jjmatchedKind = 14;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 34:
         return jjStartNfaWithStates_0(0, 32, 40);
      case 35:
         jjmatchedKind = 7;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 37:
         return jjStopAtPos(0, 22);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 39:
         return jjStartNfaWithStates_0(0, 31, 4);
      case 40:
         return jjStopAtPos(0, 26);
      case 41:
         return jjStopAtPos(0, 27);
      case 42:
         return jjStopAtPos(0, 19);
      case 43:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 44:
         return jjStopAtPos(0, 28);
      case 45:
         jjmatchedKind = 18;
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 46:
         return jjStopAtPos(0, 30);
      case 47:
         return jjStopAtPos(0, 20);
      case 58:
         return jjStopAtPos(0, 29);
      case 60:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 61:
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 62:
         jjmatchedKind = 44;
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 94:
         return jjStopAtPos(0, 21);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(1, 4);
         break;
      case 38:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(1, 13);
         break;
      case 42:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 43:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(1, 16);
         break;
      case 45:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         break;
      case 61:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000L);
      case 124:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(1, 12);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x3000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L);
      case 111:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 25, 9);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000L);
      case 111:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(4, 24, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 111:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(8, 23, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec1 = {
   0x0L, 0x0L, 0x8000000000000000L, 0x0L
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0x0L, 0x4L
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 40;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x83ff003800000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(28, 29); }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(22, 23); }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(16, 17); }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 34)
                        kind = 34;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(3, 5); }
                  if (curChar == 39)
                     { jjAddStates(6, 7); }
                  else if (curChar == 34)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 40:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  else if (curChar == 34)
                  {
                     if (kind > 38)
                        kind = 38;
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(28, 29); }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(22, 23); }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(16, 17); }
                  break;
               case 1:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 2:
                  if (curChar == 34 && kind > 38)
                     kind = 38;
                  break;
               case 3:
                  if (curChar == 39)
                     { jjAddStates(6, 7); }
                  break;
               case 5:
                  if (curChar == 39 && kind > 39)
                     kind = 39;
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(11, 12); }
                  break;
               case 12:
                  if (curChar == 46)
                     { jjCheckNAdd(13); }
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 33)
                     kind = 33;
                  { jjCheckNAdd(13); }
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 34)
                     kind = 34;
                  { jjCheckNAdd(14); }
                  break;
               case 15:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(3, 5); }
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(16, 17); }
                  break;
               case 17:
                  if (curChar == 47)
                     { jjCheckNAdd(18); }
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(18, 19); }
                  break;
               case 19:
                  if (curChar == 47)
                     { jjCheckNAdd(20); }
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(20, 21); }
                  break;
               case 21:
                  if ((0x8400000000L & l) != 0L && kind > 35)
                     kind = 35;
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(22, 23); }
                  break;
               case 23:
                  if (curChar == 58)
                     { jjCheckNAdd(24); }
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 25:
                  if (curChar == 58)
                     { jjCheckNAdd(26); }
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(26, 27); }
                  break;
               case 27:
                  if ((0x8400000000L & l) != 0L && kind > 36)
                     kind = 36;
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(28, 29); }
                  break;
               case 29:
                  if (curChar == 47)
                     { jjCheckNAdd(30); }
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(30, 31); }
                  break;
               case 31:
                  if (curChar == 47)
                     { jjCheckNAdd(32); }
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(32, 33); }
                  break;
               case 33:
                  if (curChar == 32)
                     { jjCheckNAdd(34); }
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(34, 35); }
                  break;
               case 35:
                  if (curChar == 58)
                     { jjCheckNAdd(36); }
                  break;
               case 36:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(36, 37); }
                  break;
               case 37:
                  if (curChar == 58)
                     { jjCheckNAdd(38); }
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(38, 39); }
                  break;
               case 39:
                  if ((0x8400000000L & l) != 0L && kind > 37)
                     kind = 37;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 0:
               case 9:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  { jjCheckNAdd(9); }
                  break;
               case 40:
               case 1:
                  { jjCheckNAddTwoStates(1, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((jjbitVec2[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 40:
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 6:
                  if ((jjbitVec1[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 40 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x100L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_1(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 35:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa0_2(){
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 10);
      default :
         return 1;
   }
}
static final int[] jjnextStates = {
   11, 12, 14, 16, 22, 28, 4, 7, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, 
"\174\174", "\46\46", "\41", "\55\55", "\53\53", "\53", "\55", "\52", "\57", "\136", 
"\45", "\166\145\162\144\141\144\145\162\157", "\146\141\154\163\157", 
"\156\165\154\157", "\50", "\51", "\54", "\72", "\56", "\47", "\42", null, null, null, null, null, 
null, null, null, null, null, "\74", "\76", "\74\75", "\76\75", "\75\75", "\41\75", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100000600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 9)
         {
            jjmatchedKind = 9;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 11)
         {
            jjmatchedKind = 11;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public analizadorExpresionTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public analizadorExpresionTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 40; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "COMMENT",
   "COMMENT2",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x1f9fffffff001L, 
};
static final long[] jjtoSkip = {
   0x5feL, 
};
static final long[] jjtoMore = {
   0xa00L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[40];
    private final int[] jjstateSet = new int[2 * 40];

    
    protected char curChar;
}
