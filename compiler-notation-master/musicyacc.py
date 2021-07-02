import ply.yacc as yacc
 
# Get the token map from the lexer.  This is required.
from musiclex import tokens
#import datetime
#starttime = datetime.datetime.now()
#global n
n=""
global sc
sc=""
global ss
ss=""
global x
x=0
global choice
choice=0
global remi,k,remir
remi=0
remir=0
k=[0,0,0,0,0,0,0,0]
def p_start(p): #null
    'program : begin statementlist end'
    global n
    n=""
    global sc
    sc=""
    global ss
    ss=""
    global x
    x=0
    global choice
    choice=""
    global remir
    remir=0
 

def p_begin(p):
    'begin : MAJOR CBYTE BARLINE'
    print(p[1],end="")
    print(" "+p[2]+"|",end="")
def p_end(p):
    'end : END'
    print("||",end="")
   
def p_statementlist(p): 
    'statementlist : expression' 

def p_expressions(p): #null
    'expression : empty'

def p_expression_music(p): 
    'expression : music expression'   

def p_expression_repeat(p):
    'music : REPEAT'
    global n
    #print(p[0],end="")
    print("|",end="")
    print(n,end="")
    print("|",end="")
    n=""

def p_music_pitch(p):
    'music : BARLINE '
    global n,sc,ss,k
    n=""
    global choice,remi
    choice=""
    remi=0
    k=[0,0,0,0,0,0,0,0]
    
    if(x==0):
        print("|",end="")
        sc=sc+"|"
        ss=ss+"|"
    
def p_music_octave(p):
    'music : octave dore'# 升降加音符

def p_music_m(p):
    'music : dore note'# 音符跟低高八度

def p_music_reduce(p):
    'music : redu dore'# 還原加音符

def p_music_dore(p):
    'music : dore'# 音符
    
def p_music_beat(p):
    'music : BEAT'
    #print(" _",end="")
    global a,n,sc,ss
    a=a+1
    print(" ",end="")
    print(a,end="")
    n=n+str(a)
    if(x==0):
        ss=ss+" "+str(a)
        sc=sc+" "+str(a)


def p_mdcs(p):#D.S.
    'music : dst expression SEGNO'
    global ss
    print ("|",end="")
    print (ss,end="")
    ss=""

def p_jump(p):#O+
    'music : expression OJUMP '
    global x
    x=1
    
def p_mdcsTWO(p):#D.S.2.0
    'dst : DSTART'
    global ss
    ss=""    

def p_music_dc(p):
    'music : expression CAPO'
    global sc
    print ("|",end="")
    print (sc,end="")
    sc=""

def p_num(p):#音符
    'dore : NUMBER'
    p[0]=p[1]
    global a
    a=1
    global n
    global sc,ss,choice,remi,k
    
    if(p[1]==1):
        print(" Do",end="")
        n=n+" Do"
        #remi=1
        if(x==0):
            sc=sc+" Do"
            ss=ss+" Do"
        
        if(k[1]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
            d=1
        if(choice!=None):
            remi=1
           
        
    elif(p[1]==2):
        print(" Re",end="")
        n=n+" Re"
        if(x==0):
            sc=sc+" Re"
            ss=ss+" Re"
        if(k[2]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
        if(choice!=None):
            remi=2
           
    
    elif(p[1]==3):
        print(" Mi",end="")
        n=n+" Mi"
        if(x==0):
            sc=sc+" Mi"
            ss=ss+" Mi"
        if(k[3]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
        if(choice!=None):
            remi=3
    elif(p[1]==4):
        print(" Fa",end="")
        n=n+" Fa"
        if(x==0):
            sc=sc+" Fa"
            ss=ss+" Fa"
        if(k[4]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
        if(choice!=None):
            remi=4
    elif(p[1]==5):
        print(" Sol",end="")
        n=n+" Sol"
        if(x==0):
            sc=sc+" Sol"
            ss=ss+" Sol"
        if(k[5]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
        if(choice!=None):
            remi=5
    elif(p[1]==6):
        print(" La",end="")
        n=n+" La"
        if(x==0):
            sc=sc+" La"
            ss=ss+" La"
        if(k[6]==1):
            print(choice,end="")
            sc=sc+choice
            ss=ss+choice
        if(choice!=None):
            remi=6

    elif(p[1]==7):
        print(" Si",end="")
        n=n+" Si"
        if(remir==1):
            #if(choice==None):
            print("b",end="")
            n=n+"b"
            sc=sc+" Sib"
            ss=ss+" Sib"
        else:
            if(x==0):
                sc=sc+" Si"
                ss=ss+" Si"
            if(k[7]==1):
                print(choice,end="")
                sc=sc+choice
                ss=ss+choice
            if(choice!=None):
                remi=7
    elif(p[1]==0):
        print(" PAUSE",end="")
        n=n+" PAUSE"
        if(x==0):
            sc=sc+" PAUSE"
            ss=ss+" PAUSE"
def p_octave(p):
    'octave : HLOCTAVE'#把升降寫在一起
    global n,sc,ss
    if(p[1]=='+'):
        print(" +",end="")
        n=n+" +"
        if(x==0):
            sc=sc+" +"
            ss=ss+" +"
    elif(p[1]==' -'):
        print(" -",end="")
        n=n+" -"
        if(x==0):
            sc=sc+" -"
            ss=ss+" -"

def p_redu(p):
    'redu : REDUCE'#把升降寫在一起
    global choice
    choice=""
def p_note(p):
    'note : SHARPFLAT'
    global n,sc,ss,k
    global choice
    choice=""
    if(p[1]=='#'):
        print("#",end="")
        n=n+"#"
        choice="#"
        k[remi]= 1
        if(x==0):
            sc=sc+"#"
            ss=ss+"#"
    elif(p[1]=='b'):
        n=n+"b"
        choice="b"
        #k=remi #記住他前面是甚麼音符
        k[remi]= 1 #記住他前面有哪些音符已經有升降符號
        if(x==0):
            sc=sc+"b"
            ss=ss+"b"
        print("b",end="")

global a
a=1

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
   except EOFError:
       break
   if not s: continue
   result = parser.parse(s)
   print()
   #endtime = datetime.datetime.now()
   #print ((endtime - starttime))
   #print(result)