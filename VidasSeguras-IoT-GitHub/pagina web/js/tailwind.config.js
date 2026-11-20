tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        navy: {
                            DEFAULT: '#0B2545',
                            light: '#133763',
                            dark: '#07182E',
                        },
                        safety: {
                            amber: '#F59E0B',
                            orange: '#EA580C',
                        },
                        tech: {
                            cyan: '#38BDF8',
                        }
                    },
                    fontFamily: {
                        heading: ['Montserrat', 'sans-serif'],
                        sans: ['Inter', 'sans-serif'],
                    },
                    animation: {
                        'pulse-fast': 'pulse 1s cubic-bezier(0.4, 0, 0.6, 1) infinite',
                        'radar': 'ping 2.2s cubic-bezier(0, 0, 0.2, 1) infinite',
                    }
                }
            }
        }
