package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entity.UserWallet;
import com.wallet.entity.Wallet;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
}
