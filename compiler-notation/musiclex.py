import ply.lex as lex
#import datetime
#starttime = datetime.datetime.now()
 # List of token names. This is always required
tokens = [
    'NUMBER',#DO RE MI
    'SHARPFLAT',#升降
    'BARLINE',#小節線
    'BEAT',#節拍
    'REPEAT',#反覆
    'END',#結束
    'HLOCTAVE',#高八度
    'SEGNO',#D.S.連續記號
    'CAPO',#D.C.
    'DSTART',#判別D.S.的起始記號S※
    'OJUMP',#O+跳躍符號
    'REDUCE',#n 還原記號
    'CBYTE',#節拍 每4分音符為一拍
    'MAJOR',#大調 分為CEF
]

# Regular expression rules for simple tokens

t_BARLINE   = r'\|'
t_BEAT  = r'_'
t_END  = r'\|\|'
t_REDUCE=r'n'

# A regular expression rule with some action code
def t_NUMBER(t):
    r'1|2|3|4|5|6|7|0'
    t.value = int(t.value)    
    return t

def t_SHARPFLAT(t):
    r'\#|b' 
    return t

def t_REPEAT(t):
    r'\:\|\|'
    return t

def t_HLOCTAVE(t):
    r'\+|-'   
    return t

def t_SEGNO(t):
    r'D.S.'   
    return t

def t_CAPO(t):
    r'D.C.'   
    return t

def t_DSTART(t):
    r'S'   
    return t

def t_OJUMP(t):
    r'O\+'   
    return t    

def t_CBYTE(t):
    r'C[1-4]/4'   
    return t

def t_MAJOR(t):
    r'T\=C'   
    return t    

def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

    # A string containing ignored characters (spaces and tabs)
t_ignore  = ' \t'

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

    # Build the lexer
lexer = lex.lex()

#data="T=C C2/4| #5 _ 6 _ |S +2 _ 0 _ O+ | 7 _ _ _ D.S. | O+ +1 _ _ _|"
    # Give the lexer some input


def main():
    data=input("input data>")
    lexer.input(data)
    # Tokenize
    while True:
        tok = lexer.token()
        if not tok: 
            break      # No more input
        print(tok)
    #endtime = datetime.datetime.now()
    #print ((endtime - starttime))
if __name__ == '__main__':
    main()
    