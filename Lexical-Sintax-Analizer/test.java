/* Generated By:JavaCC: Do not edit this line. test.java */
import java.io.*;
class test implements testConstants {
        public static void main( String[] args )throws ParseException, Exception
        {
                try
                {
                test analizador = new test( System.in ) ;
                        analizador.Programa();
                        System.out.println("\u005ctAnalizador ha terminado.");
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("\u005ctAnalizador ha terminado.");
                }
        }

  static final public void Programa() throws ParseException {
    jj_consume_token(PROGRAM);
    jj_consume_token(ID);
    jj_consume_token(22);
    Programa_AUX();
  }

  static final public void Programa_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case CHAR:
      VARS();
      break;
    case VOID:
    case VECTOR:
    case EMPTY:
    case 23:
      Programa_AUX2();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Programa_AUX2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
    case INT:
    case FLOAT:
    case CHAR:
    case VECTOR:
      MODULO();
      BLOQUE();
      break;
    case EMPTY:
    case 23:
      BLOQUE();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void BLOQUE() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      BLOQUE_AUX();
      jj_consume_token(24);
      break;
    case EMPTY:
      jj_consume_token(EMPTY);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void BLOQUE_AUX() throws ParseException {
    ESTATUTO();
    BLOQUE_AUX();
  }

  static final public void ESTATUTO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      ASIGNACION();
      break;
    case IF:
      CONDICION();
      break;
    case PRINT:
      ESCRITURA();
      break;
    case WHILE:
      CICLO();
      break;
      LLAMADA_FUNC();
      break;
    case RETURN:
      RETORNO();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void MEGAEXPRESION() throws ParseException {
    EXPRESION();
    MEGAEXPRESION_AUX();
    EXPRESION();
  }

  static final public void MEGAEXPRESION_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 25:
      jj_consume_token(25);
      break;
      jj_consume_token(25);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void EXPRESION() throws ParseException {
    EXP();
    EXPRESION_AUX();
    EXP();
  }

  static final public void EXPRESION_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 26:
      jj_consume_token(26);
      break;
    case 27:
      jj_consume_token(27);
      break;
    case 28:
      jj_consume_token(28);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void EXP() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
    case cte_f:
    case ID:
    case 29:
    case 30:
    case 33:
      TERMINO();
      EXP_AUX();
      EXP();
      break;
      TERMINO();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void EXP_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
      break;
    case 30:
      jj_consume_token(30);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TERMINO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
    case cte_f:
    case ID:
    case 29:
    case 30:
    case 33:
      FACTOR();
      TERMINO_AUX();
      TERMINO();
      break;
      FACTOR();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TERMINO_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      break;
    case 32:
      jj_consume_token(32);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void FACTOR() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 33:
      jj_consume_token(33);
      MEGAEXPRESION();
      jj_consume_token(34);
      break;
    case 29:
    case 30:
      FACTOR_AUX();
      VARCTE();
      break;
    case cte_i:
    case cte_f:
    case ID:
      VARCTE();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void FACTOR_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
      break;
    case 30:
      jj_consume_token(30);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARCTE() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case cte_i:
      jj_consume_token(cte_i);
      break;
    case cte_f:
      jj_consume_token(cte_f);
      break;
      jj_consume_token(ID);
      jj_consume_token(35);
      EXP();
      jj_consume_token(36);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void CONDICION() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(33);
    MEGAEXPRESION();
    jj_consume_token(34);
    CONDICION_AUX();
    jj_consume_token(22);
  }

  static final public void CONDICION_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EMPTY:
    case 23:
      BLOQUE();
      break;
    case ELSE:
      jj_consume_token(ELSE);
      CONDICION();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void CICLO() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(33);
    MEGAEXPRESION();
    jj_consume_token(34);
    BLOQUE();
  }

  static final public void VARS() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case CHAR:
      TIPO();
      VARS_AUX1();
      jj_consume_token(22);
      break;
      TIPO();
      VARS_AUX2();
      jj_consume_token(22);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARS_AUX1() throws ParseException {
    jj_consume_token(VECTOR);
    jj_consume_token(ID);
    jj_consume_token(35);
    EXP();
    jj_consume_token(36);
    VARS_AUX1_1();
  }

  static final public void VARS_AUX1_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 37:
      jj_consume_token(37);
      jj_consume_token(23);
      VARS_AUX1_2();
      jj_consume_token(24);
      break;
    case EMPTY:
      jj_consume_token(EMPTY);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARS_AUX1_2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
    case cte_f:
    case cte_c:
      VARS_AUX2_2();
      break;
      VARS_AUX2_2();
      jj_consume_token(38);
      VARS_AUX1_2();
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARS_AUX2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      VARS_AUX2_1();
      jj_consume_token(38);
      VARS_AUX2();
      break;
      VARS_AUX2_1();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARS_AUX2_1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
      jj_consume_token(ID);
      jj_consume_token(37);
      VARS_AUX2_2();
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VARS_AUX2_2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
      jj_consume_token(cte_i);
      break;
    case cte_f:
      jj_consume_token(cte_f);
      break;
    case cte_c:
      jj_consume_token(cte_c);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void MODULO() throws ParseException {
    MODULO_TIPO();
    jj_consume_token(ID);
    jj_consume_token(33);
    MODULO_AUX();
    jj_consume_token(34);
    BLOQUE();
  }

  static final public void MODULO_TIPO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
      jj_consume_token(VOID);
      break;
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    case VECTOR:
      jj_consume_token(VECTOR);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void MODULO_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case CHAR:
      TIPO();
      jj_consume_token(ID);
      break;
      TIPO();
      jj_consume_token(ID);
      jj_consume_token(38);
      MODULO_AUX();
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void RETORNO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RETURN:
      jj_consume_token(RETURN);
      VARCTE();
      jj_consume_token(22);
      break;
      jj_consume_token(RETURN);
      EXP();
      jj_consume_token(22);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void LLAMADA_FUNC() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(33);
    LLAMADA_AUX();
    jj_consume_token(34);
    jj_consume_token(22);
  }

  static final public void LLAMADA_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
    case cte_f:
    case ID:
    case 29:
    case 30:
    case 33:
      LLAMADA_PARAM();
      break;
      LLAMADA_PARAM();
      jj_consume_token(38);
      LLAMADA_AUX();
      break;
    case EMPTY:
      jj_consume_token(EMPTY);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void LLAMADA_PARAM() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case cte_i:
    case cte_f:
    case 29:
    case 30:
    case 33:
      EXP();
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TIPO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ASIGNACION() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(37);
    EXPRESION();
    jj_consume_token(22);
  }

  static final public void ESCRITURA() throws ParseException {
    jj_consume_token(PRINT);
    jj_consume_token(33);
    ESCRITURA_AUX();
    jj_consume_token(34);
    jj_consume_token(22);
  }

  static final public void ESCRITURA_AUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case cte_i:
    case cte_f:
    case ID:
    case 29:
    case 30:
    case 33:
      EXPRESION();
      break;
      EXPRESION();
      jj_consume_token(39);
      ESCRITURA_AUX();
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public testTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x801782,0x801782,0x801000,0x8868,0x2000000,0x1c000000,0x6000e000,0x60000000,0x6000e000,0x80000000,0x6000e000,0x60000000,0xe000,0x801010,0x380,0x1000,0x16000,0x8000,0x8000,0x16000,0x782,0x380,0x800,0x6000f000,0x6000e000,0x380,0x6000e000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x2,0x0,0x2,0x1,0x2,0x0,0x0,0x0,0x0,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x2,0x2,0x0,0x2,};
   }

  /** Constructor with InputStream. */
  public test(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public test(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new testTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public test(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new testTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public test(testTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(testTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[40];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 40; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}