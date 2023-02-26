
static boolean isDelim(char c) { // тру если пробел
    return c == ' ';
    }

    static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    
    static int priority(char op) {
      switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
      case '%':
        return 2;
      default:
        return -1;
      }
    }

    static void processOperator(LinkedList<Integer> st, char op) { 
      int r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
      int l = st.removeLast(); // также 
      switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
      case '+':
        st.add(l + r);
        break;
      case '-':
        st.add(l - r);
        break;
      case '*':
        st.add(l * r);
        break;
      case '/':
        st.add(l / r);
        break;
      case '%':
        st.add(l % r);
        break;
      }
    }

