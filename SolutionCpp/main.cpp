#include "utils/Utils.h"

using namespace std;

int main() {
    Utils::run(8,[](){
        Utils::print(Utils::randomArray(30, 0, 1));
    });
    return 0;
}
