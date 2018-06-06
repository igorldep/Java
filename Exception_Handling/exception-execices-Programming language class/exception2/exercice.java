class A {
    private:
        int j;
    float g;
    B b;
    public:
        void f2() {
            // ...
            try {
                // ...
                try {
                    // ...
                    b.f1();
                    // ...
                    if ( /* ... */ )
                        throw j;
                    // ...
                    if ( /* ... */ )
                        throw g;
                    // ...
                } catch (int) {
                    // ...
                }
                //...
            } catch (float) {
                // ...
            }
            // ...
        }
};
class B {
    private:
        int k;
    float f;
    public:
        void f1() {
            // ...
            try {
                // ...
                if ( /* ... */ )
                    throw k;
                // ...
                if ( /* ... */ )
                    throw f;
                // ...
            } catch (float) {
                // ...
            }
            // ...
        }
};
void main() {
    A a;
    // ...
    a.f2();
    // ...
}