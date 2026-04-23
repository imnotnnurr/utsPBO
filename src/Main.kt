class Dokter(private var kuotaHarian: Int) {

    fun cekKuota(): Int {
        return kuotaHarian
    }

    fun kurangiKuota(): Boolean {
        return if (kuotaHarian > 0) {
            kuotaHarian--
            true
        } else {
            false
        }
    }
}

class Antrian {
    private var nomorTerakhir: Int = 0

    fun ambilNomor(): Int {
        nomorTerakhir++
        return nomorTerakhir
    }
}

class Pasien(private val nama: String) {

    private var nomorAntrian: Int? = null

    fun daftar(dokter: Dokter, antrian: Antrian) {
        println("Pasien $nama mencoba mendaftar...")

        if (dokter.cekKuota() <= 0) {
            println("❌ Pendaftaran gagal! Kuota dokter sudah habis.\n")
            return
        }

        val berhasil = dokter.kurangiKuota()

        if (berhasil) {
            nomorAntrian = antrian.ambilNomor()
            println("✅ Pendaftaran berhasil!")
            println("Nomor antrian $nama: $nomorAntrian")
            println("Sisa kuota dokter: ${dokter.cekKuota()}\n")
        } else {
            println("❌ Pendaftaran gagal!\n")
        }
    }
}

fun main() {
    val dokter = Dokter(1) // kuota hanya 1
    val antrian = Antrian()

    val pasien1 = Pasien("Andi")
    val pasien2 = Pasien("Budi")

    // 🔴 Simulasi GAGAL & SUKSES

    // Sukses (kuota masih ada)
    pasien1.daftar(dokter, antrian)

    // Gagal (kuota sudah habis)
    pasien2.daftar(dokter, antrian)
}