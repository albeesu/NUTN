import ply.yacc as yacc

# Get the token map from the lexer.  This is required.
from musiclex import tokens
#import datetime
#starttime = datetime.datetime.now()
def p_start(p): #null
    'program : begin statementlist end'
    p[0]=("program",p[1],p[2],p[3])
def p_begin(p):
    'begin : MAJOR CBYTE BARLINE'
    p[0] = ('begin',p[1],p[2],p[3])
    
def p_end(p):
    'end : END'
    p[0] = ('END',p[1])
   
def p_statementlist(p): 
    'statementlist : expression' 
    p[0]=("statementlist",p[1])

def p_expressions(p): #null
    'expression : empty'
    p[0]=(p[1])

def p_expression_music(p): 
    'expression : music expression'   
    p[0]=("expression",p[1],p[2])

def p_expression_repeat(p):
    'music : expression REPEAT'
    p[0]=p[1]
    p[0] = ("music",p[1],"REPEAT")

def p_music_pitch(p):
    'music : BARLINE '
    p[0]=p[1]
    p[0] = ("music","BARLINE",p[1])
    
def p_music_octave(p):
    'music : octave dore'# 升降加音符
    #p[0]=p[1]
    p[0]=("music",p[1],p[2])

def p_music_m(p):
    'music : dore note'# 音符跟低高八度
    #p[0]=p[1]
    p[0]=("music",p[1],p[2])

def p_music_reduce(p):
    'music : redu dore'# 還原加音符
    #p[0]=p[1]
    p[0]=("music",p[1],p[2])

def p_music_dore(p):
    'music : NUMBER'# 音符
    p[0]=p[1]
    p[0]=("music",'NUMBER',p[1])

def p_music_beat(p):
    'music : BEAT'
    p[0]=p[1]
    p[0] = ("music",'BEAT',p[1])

def p_mdcs(p):#D.S.
    'music : dst expression SEGNO'
    p[0]=p[2]
    p[0] = ("music",'SEGNO',p[1],p[2])

def p_jump(p):#O+
    'music : expression OJUMP '
    p[0]=p[1]
    p[0] = ("music",'OJUMP',p[1])
    global x
    x=1
    
def p_mdcsTWO(p):#D.S.2.0
    'dst : DSTART'
    p[0]=p[1]
    p[0] = ('DSTART',p[1])

def p_music_dc(p):
    'music : expression CAPO'
    p[0]=p[1]
    p[0] = ("music",'CAPO',p[1])

def p_num(p):#音符
    'dore : NUMBER'
    p[0]=p[1]
    p[0] = ('NUMBER',p[1])

def p_octave(p):
    'octave : HLOCTAVE'#把升降寫在一起
    p[0]=p[1]
    p[0] = ('HLOCTAVE',p[1])

def p_redu(p):
    'redu : REDUCE'#把升降寫在一起
    p[0]=p[1]
    p[0] = ('REDUCE',p[1])
    
def p_note(p):
    'note : SHARPFLAT'
    p[0]=p[1]
    p[0] = ('SHARPFLAT',p[1])

def p_empty(p):
    'empty :'
    pass 
# Error rule for syntax errors
def p_error(p):
    print("Syntax error in input!")
 
 
# Build the parser
parser = yacc.yacc()

while True:
   try:
       s = input('music > ')
       #s = '3 + 5 * (10 - 20)'
   except EOFError:
       break
   if not s: continue
   result = parser.parse(s)
   print(result)
   #endtime = datetime.datetime.now()
   #print ((endtime - starttime))
   