(function () {
            'use strict';

            /* ---------------------------------------------------------
             * 1. MENÚ MÓVIL RESPONSIVO
             * --------------------------------------------------------- */
            const mobileBtn = document.getElementById('mobile-menu-btn');
            const mobileMenu = document.getElementById('mobile-menu');
            const iconOpen = document.getElementById('icon-open');
            const iconClose = document.getElementById('icon-close');
            const mobileLinks = document.querySelectorAll('.mobile-link');

            function toggleMobileMenu(forceClose = false) {
                const isHidden = mobileMenu.classList.contains('hidden');
                const shouldOpen = forceClose ? false : isHidden;
                mobileMenu.classList.toggle('hidden', !shouldOpen);
                iconOpen.classList.toggle('hidden', shouldOpen);
                iconClose.classList.toggle('hidden', !shouldOpen);
                mobileBtn.setAttribute('aria-expanded', String(shouldOpen));
            }

            mobileBtn.addEventListener('click', () => toggleMobileMenu());
            mobileLinks.forEach(link => link.addEventListener('click', () => toggleMobileMenu(true)));

            /* ---------------------------------------------------------
             * 2. ANIMACIONES SUAVES AL HACER SCROLL (IntersectionObserver)
             * --------------------------------------------------------- */
            const revealElements = document.querySelectorAll('.reveal');
            if ('IntersectionObserver' in window) {
                const observer = new IntersectionObserver((entries, obs) => {
                    entries.forEach(entry => {
                        if (entry.isIntersecting) {
                            entry.target.classList.add('visible');
                            obs.unobserve(entry.target);
                        }
                    });
                }, { threshold: 0.12 });
                revealElements.forEach(el => observer.observe(el));
            } else {
                revealElements.forEach(el => el.classList.add('visible'));
            }

            /* ---------------------------------------------------------
             * 3. SIMULADOR INTERACTIVO DEL DASHBOARD DE MONITOREO
             * --------------------------------------------------------- */
            const initialMiners = () => ([
                {
                    id: 'VS-101',
                    name: 'Roberto Quispe',
                    level: 'Nivel 1 — Galería San Pedro',
                    co: 11,
                    bpm: 78,
                    panic: false,
                    rssi: -82,
                    status: 'normal'
                },
                {
                    id: 'VS-104',
                    name: 'Javier Choque',
                    level: 'Nivel 2 — Socavón Pailaviri',
                    co: 14,
                    bpm: 84,
                    panic: false,
                    rssi: -89,
                    status: 'normal'
                },
                {
                    id: 'VS-109',
                    name: 'Efraín Flores',
                    level: 'Nivel 3 — Rampa Esperanza',
                    co: 9,
                    bpm: 76,
                    panic: false,
                    rssi: -94,
                    status: 'normal'
                }
            ]);

            let miners = initialMiners();
            let simMode = 'normal'; // 'normal' | 'co' | 'panic'

            const minersGrid = document.getElementById('miners-grid');
            const dashboardFrame = document.getElementById('dashboard-frame');
            const statusDot = document.getElementById('system-status-dot');
            const statusText = document.getElementById('system-status-text');
            const emergencyBanner = document.getElementById('emergency-banner');
            const emergencyTitle = document.getElementById('emergency-title');
            const emergencyProtocol = document.getElementById('emergency-protocol');
            const eventLog = document.getElementById('event-log');
            const simClock = document.getElementById('sim-clock');
            const simLatency = document.getElementById('sim-latency');

            function getTimeStr() {
                return new Date().toLocaleTimeString('es-BO', { hour12: false });
            }

            function addLog(message, type = 'info') {
                const colors = {
                    info: 'text-slate-300',
                    ok: 'text-emerald-400',
                    warn: 'text-safety-amber',
                    danger: 'text-red-400 font-bold'
                };
                const li = document.createElement('li');
                li.className = `flex items-start gap-2 ${colors[type] || colors.info}`;
                li.innerHTML = `<span class="text-slate-500 shrink-0">[${getTimeStr()}]</span><span>${message}</span>`;
                eventLog.prepend(li);
                while (eventLog.children.length > 10) {
                    eventLog.removeChild(eventLog.lastChild);
                }
            }

            function renderMiners() {
                minersGrid.innerHTML = miners.map(m => {
                    const isDanger = m.status !== 'normal';
                    const cardClasses = isDanger
                        ? 'bg-red-950/60 border-2 border-red-500 emergency-flash'
                        : 'bg-slate-800/70 border border-slate-700/80';
                    const badgeClasses = isDanger
                        ? 'bg-red-600 text-white animate-pulse-fast'
                        : 'bg-emerald-500/20 text-emerald-300';
                    const badgeLabel = m.status === 'co'
                        ? 'ALERTA: CO CRÍTICO'
                        : m.status === 'panic'
                            ? 'BOTÓN DE PÁNICO'
                            : 'NORMAL';
                    const coColor = m.co >= 50 ? 'text-red-400' : 'text-emerald-400';
                    const bpmColor = m.bpm >= 115 ? 'text-safety-amber' : 'text-tech-cyan';

                    return `
                        <div class="rounded-2xl p-5 transition-all ${cardClasses}">
                            <div class="flex items-start justify-between gap-2 mb-4">
                                <div>
                                    <p class="font-heading font-bold text-base text-white">${m.name}</p>
                                    <p class="text-xs text-slate-400">${m.level}</p>
                                    <p class="text-[11px] font-mono text-slate-500 mt-0.5">Casco ID: ${m.id}</p>
                                </div>
                                <span class="px-2.5 py-1 rounded-lg text-[10px] font-heading font-extrabold uppercase tracking-wider shrink-0 ${badgeClasses}">
                                    ${badgeLabel}
                                </span>
                            </div>

                            <div class="grid grid-cols-2 gap-3 mb-3">
                                <div class="rounded-xl bg-slate-950/70 p-3 border border-white/5">
                                    <span class="block text-[10px] uppercase tracking-wider text-slate-400">Gas CO (ppm)</span>
                                    <span class="font-mono font-bold text-xl ${coColor}">${m.co} <span class="text-xs font-normal">ppm</span></span>
                                </div>
                                <div class="rounded-xl bg-slate-950/70 p-3 border border-white/5">
                                    <span class="block text-[10px] uppercase tracking-wider text-slate-400">Pulso Cardíaco</span>
                                    <span class="font-mono font-bold text-xl ${bpmColor}">${m.bpm} <span class="text-xs font-normal">BPM</span></span>
                                </div>
                            </div>

                            <div class="flex items-center justify-between text-xs pt-2 border-t border-white/10">
                                <span class="text-slate-300">Pánico: <strong class="${m.panic ? 'text-red-400' : 'text-slate-400'}">${m.panic ? 'ACTIVADO' : 'Inactivo'}</strong></span>
                                <span class="font-mono text-tech-cyan">LoRa ${m.rssi} dBm</span>
                            </div>
                        </div>
                    `;
                }).join('');
            }

            function triggerCOEmergency() {
                simMode = 'co';
                miners = initialMiners();
                miners[1].co = 148;
                miners[1].bpm = 128;
                miners[1].status = 'co';

                dashboardFrame.classList.remove('border-slate-700/80');
                dashboardFrame.classList.add('border-red-500', 'emergency-flash');
                statusDot.className = 'w-3.5 h-3.5 rounded-full bg-red-500 animate-ping';
                statusText.className = 'text-xs font-mono text-red-400 font-bold';
                statusText.textContent = '¡ALERTA NIVEL 2! CONCENTRACIÓN LETAL DE MONÓXIDO DE CARBONO DETECTADA';

                emergencyBanner.classList.remove('hidden');
                emergencyTitle.textContent = 'ALERTA DE BOCHORNO (CO: 148 ppm) — NIVEL 2: SOCAVÓN PAILAVIRI';
                emergencyProtocol.textContent = 'Protocolo Inmediato: 1) Activar alarma sonora en bocamina. 2) Ordenar evacuación inmediata de Nivel 2. 3) Despachar brigada de rescate con equipo autónomo hacia Casco VS-104 (Javier Choque).';

                simLatency.textContent = '1.8s';
                addLog('ALERTA CRÍTICA [VS-104]: Gas CO superó umbral seguro (148 ppm) y pulso elevado (128 BPM) en Nivel 2.', 'danger');
                addLog('Protocolo de evacuación y rescate despachado desde estación local de bocamina.', 'warn');
                renderMiners();
            }

            function triggerPanicEmergency() {
                simMode = 'panic';
                miners = initialMiners();
                miners[2].panic = true;
                miners[2].bpm = 136;
                miners[2].co = 24;
                miners[2].status = 'panic';

                dashboardFrame.classList.remove('border-slate-700/80');
                dashboardFrame.classList.add('border-red-500', 'emergency-flash');
                statusDot.className = 'w-3.5 h-3.5 rounded-full bg-red-500 animate-ping';
                statusText.className = 'text-xs font-mono text-red-400 font-bold';
                statusText.textContent = '¡EMERGENCIA MÁXIMA NIVEL 3! BOTÓN DE PÁNICO ACTIVADO EN INTERIOR MINA';

                emergencyBanner.classList.remove('hidden');
                emergencyTitle.textContent = 'BOTÓN DE PÁNICO ACTIVADO — NIVEL 3: RAMPA ESPERANZA';
                emergencyProtocol.textContent = 'Protocolo Inmediato: 1) Fijar última zona de cobertura LoRaWAN (Gateway GW-POT-01, Nivel 3). 2) Movilizar cuadrilla de rescate para posible derrumbe o atrapamiento de Efraín Flores (VS-109). 3) Notificar a emergencias.';

                simLatency.textContent = '1.4s';
                addLog('EMERGENCIA MÁXIMA [VS-109]: Botón de pánico físico presionado en Nivel 3 — Rampa Esperanza.', 'danger');
                addLog('Ubicación aproximada triangulada por Gateway GW-POT-01. Tiempo de alerta: 1.4 segundos.', 'warn');
                renderMiners();
            }

            function resetSimulation() {
                simMode = 'normal';
                miners = initialMiners();

                dashboardFrame.classList.remove('border-red-500', 'emergency-flash');
                dashboardFrame.classList.add('border-slate-700/80');
                statusDot.className = 'w-3.5 h-3.5 rounded-full bg-emerald-400 shadow-lg shadow-emerald-400/50';
                statusText.className = 'text-xs font-mono text-emerald-400';
                statusText.textContent = 'OPERACIÓN NORMAL • RED LORAWAN ACTIVA (SIN INTERNET)';

                emergencyBanner.classList.add('hidden');
                simLatency.textContent = '1.2s';
                addLog('Sistema restablecido. Todos los nodos en Niveles 1, 2 y 3 reportan parámetros seguros.', 'ok');
                renderMiners();
            }

            document.getElementById('btn-sim-co').addEventListener('click', triggerCOEmergency);
            document.getElementById('btn-sim-panic').addEventListener('click', triggerPanicEmergency);
            document.getElementById('btn-sim-reset').addEventListener('click', resetSimulation);

            // Actualización en vivo de reloj y ligera variación realista de telemetría
            function updateLiveClockAndTelemetry() {
                simClock.textContent = getTimeStr();
                miners.forEach(m => {
                    if (m.status === 'normal') {
                        m.bpm = Math.max(70, Math.min(92, m.bpm + (Math.floor(Math.random() * 3) - 1)));
                        m.co = Math.max(6, Math.min(18, m.co + (Math.floor(Math.random() * 3) - 1)));
                    } else if (m.status === 'co') {
                        m.co = Math.max(135, Math.min(165, m.co + (Math.floor(Math.random() * 5) - 2)));
                        m.bpm = Math.max(122, Math.min(138, m.bpm + (Math.floor(Math.random() * 3) - 1)));
                    } else if (m.status === 'panic') {
                        m.bpm = Math.max(128, Math.min(144, m.bpm + (Math.floor(Math.random() * 3) - 1)));
                    }
                });
                renderMiners();
            }

            // Inicialización del Simulador
            simClock.textContent = getTimeStr();
            addLog('Estación Edge Computing iniciada en bocamina. 3 cascos inteligentes enlazados vía LoRaWAN.', 'ok');
            addLog('Calibración de sensores CO vigente. Monitoreo continuo en niveles 1, 2 y 3.', 'info');
            renderMiners();
            setInterval(updateLiveClockAndTelemetry, 2500);

            /* ---------------------------------------------------------
             * 4. SELECCIÓN RÁPIDA DE PLANES Y FORMULARIO DE CONTACTO
             * --------------------------------------------------------- */
            const modalidadSelect = document.getElementById('f-modalidad');
            document.querySelectorAll('.select-plan-btn').forEach(btn => {
                btn.addEventListener('click', () => {
                    const plan = btn.getAttribute('data-plan');
                    if (plan && modalidadSelect) {
                        modalidadSelect.value = plan;
                    }
                });
            });

            const demoForm = document.getElementById('demo-form');
            const formError = document.getElementById('form-error');
            const formSuccess = document.getElementById('form-success');
            const formSuccessDetail = document.getElementById('form-success-detail');

            demoForm.addEventListener('submit', function (e) {
                e.preventDefault();
                const nombre = document.getElementById('f-nombre').value.trim();
                const empresa = document.getElementById('f-empresa').value.trim();
                const telefono = document.getElementById('f-telefono').value.trim();
                const mineros = document.getElementById('f-mineros').value.trim();
                const modalidad = modalidadSelect.value;

                if (!nombre || !empresa || !telefono || !mineros || Number(mineros) < 1) {
                    formError.classList.remove('hidden');
                    formSuccess.classList.add('hidden');
                    return;
                }

                formError.classList.add('hidden');
                formSuccessDetail.textContent = `Gracias, ${nombre}. Vista previa de la solicitud de "${empresa}" (${mineros} mineros) para "${modalidad}", con teléfono ${telefono}. Este formulario es una demostración: no envía datos ni agenda visitas automáticamente.`;
                formSuccess.classList.remove('hidden');
                demoForm.reset();
            });
        })();
